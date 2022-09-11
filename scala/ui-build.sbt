import scala.sys.process.Process

val Success = 0

val Error = 1

PlayKeys.playRunHooks += baseDirectory.map(FrontendRunHook.apply).value

val isWindows = System.getProperty("os.name").toLowerCase().contains("win")

def runOnCommandline(firstScript: String, otherScripts: String*)(implicit
                                                                 dir: File
): Int = {
  def command(script: String) = {
    if (isWindows) { Process("cmd /c set CI=true&&" + script, dir) }
    else { Process("env CI=true " + script, dir) }
  }
  otherScripts
    .foldLeft(command(firstScript)) { (acc, other) =>
      acc #&& command(other)
    }
} !

def isNodeModulesInstalled(implicit dir: File): Boolean =
  (dir / "node_modules").exists()

def runNpmInstall(implicit dir: File): Int =
  if (isNodeModulesInstalled) Success
  else runOnCommandline(FrontendCommands.dependencyInstall)

def ifNodeModulesInstalled(task: => Int)(implicit dir: File): Int =
  if (runNpmInstall == Success) task
  else Error

def executeUiCodeStyle(implicit dir: File): Int = ifNodeModulesInstalled(
  runOnCommandline(FrontendCommands.prettier, FrontendCommands.eslint)
)

def executeUiCodeStyleCheck(implicit dir: File): Int = ifNodeModulesInstalled(
  runOnCommandline(FrontendCommands.prettierCheck, FrontendCommands.eslintCheck)
)

def executeUiTests(implicit dir: File): Int = ifNodeModulesInstalled(
  runOnCommandline(FrontendCommands.test)
)

def executeProdBuild(implicit dir: File): Int = ifNodeModulesInstalled(
  runOnCommandline(FrontendCommands.build)
)

lazy val `ui-code-style` = taskKey[Unit]("Apply code style.")

`ui-code-style` := {
  implicit val userInterfaceRoot = baseDirectory.value / "ui"
  if (executeUiCodeStyle != Success)
    throw new Exception("UI code style failed!")
}

lazy val `ui-code-style-check` =
  taskKey[Unit]("Check if code style was applied.")

`ui-code-style-check` := {
  implicit val userInterfaceRoot = baseDirectory.value / "ui"
  if (executeUiCodeStyleCheck != Success)
    throw new Exception("UI code style check failed!")
}

lazy val `ui-test` = taskKey[Unit]("Run UI tests when testing application.")

`ui-test` := {
  implicit val userInterfaceRoot = baseDirectory.value / "ui"
  if (executeUiTests != Success) throw new Exception("UI tests failed!")
}

lazy val `ui-prod-build` =
  taskKey[Unit]("Run UI build when packaging the application.")

test := ((test in Test) dependsOn `ui-test`).value