import { useState } from "react";

function useCart() {
    const [items, setItems] = useState([]);

    const addItem = newItem => {
       const item = items.find(({ id }) => id === newItem.id);

        if(item) {
            setItems(currentItems => [ ...currentItems.filter(({ id }) => id !== item.id), { ...newItem, amount: item.amount + 1 }])
        } else {
            setItems([ ...items, { ...newItem, amount: 1 } ])
        }
    };

    const removeItem = itemId => {
        const itemCount = items.find(({ id }) => id === itemId).amount;

        if(itemCount === 1) {
            setItems(items.filter(({ id }) => id !== itemId))
        } else {
            const item = items.find(({ id }) => id === itemId);
            setItems([ ...items.filter(({ id }) => id !== itemId), { ...item, amount: item.amount - 1 } ])
        }
    };

    return {
        items,
        addItem,
        removeItem,
    }
}

export default useCart;
