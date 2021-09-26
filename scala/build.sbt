name := "backendscala"

version := "1.0"

lazy val `backendscala` = (project in file(".")).enablePlugins(PlayScala).disablePlugins(PlayFilters)
//add docker configs

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"

resolvers += Resolver.jcenterRepo
resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq( ehcache , ws , specs2 % Test , guice, filters )
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "4.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "4.0.0",
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
  "org.xerial"        %  "sqlite-jdbc" % "3.30.1",
  "com.mohiva" %% "play-silhouette" % "6.1.1",
  "com.mohiva" %% "play-silhouette-password-bcrypt" % "6.1.1",
  "com.mohiva" %% "play-silhouette-persistence" % "6.1.1",
  "com.mohiva" %% "play-silhouette-crypto-jca" % "6.1.1",
  "net.codingwell" %% "scala-guice" % "4.2.6"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

