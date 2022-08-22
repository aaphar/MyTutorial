package oop.Abstraction.Challange;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // list was empty, this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {

            int comparison = currentItem.compareTo(newItem);

            if (comparison < 0) {
                // newItem is greater, move right if possible
                // check for newItem where it has to be
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there no next, so insert at the end of the list
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);

                    //currentItem.setNext(newItem).setPrevious(currentItem);

                    return true;
                }
            } else if (comparison > 0) {
                // newItem is less, insert before
                if (currentItem.previous() != null) {
                    // newItem take place of currentItem
                    currentItem.previous().setNext(newItem);
                    // newItem's previous become currentItem's previous,
                    // previous item never change
                    newItem.setPrevious(currentItem.previous());
                    // newItem's next become currentItem,
                    // they change the places
                    newItem.setNext(currentItem);
                    // currentItem's previous become newItem
                    currentItem.setPrevious(newItem);
                } else {
                    // the node with a previous is the root
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;

            } else {
                //equal
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // found the item to delete

                //if this item is root, make root next item
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;

            } else if (comparison < 0) {
                // currentItem less than item we want to delete,
                // we haven't reached the item we want to delete

                currentItem = currentItem.next();
            } else { // comparison>0
                //We are at the item greater than the one to be deleted.
                // so item is not in the list
                return false;
            }
        }
        // We have reached end of the list
        // without finding item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
