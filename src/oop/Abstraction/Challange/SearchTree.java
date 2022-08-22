package oop.Abstraction.Challange;

public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // tree was empty, newItem become root of the tree
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {

            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                // passed value greater than current value
                if (currentItem.next() != null) {
                    // if tree has next element then move to it
                    currentItem = currentItem.next();
                } else {
                    // if we have reached end of the right subtrees,
                    // insert value to right child
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) {
                // passed value is less than current value
                if (currentItem.previous() != null) {
                    // if tree has previous element move to it
                    currentItem = currentItem.previous();
                } else {
                    // we have reached end of the left subtrees,
                    // insert value to empty left child
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                // if passed value equal to current item
                System.out.println(newItem.getValue() + " is already present!");
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
        ListItem parentItem = currentItem;

        while (currentItem != null) {

            int comparison = currentItem.compareTo(item);

            if (comparison < 0) {
                // passed value is greater than current value
                // item to be deleted is in the right subtree
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                // passed value is less than current value
                // item to be deleted is in the left subtree
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                // passed value is equal the current item
                // we found item (currentItem) to be deleted
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        // we can't actually get here, but Java complains if there is no return
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() == null) {
            // no right tree, so make parent point to left tre (which may be null)
            // maybe have only left child

            if (parent.next() == item) {
                // if deleting item is the right child of parent
                // left(have only left) child of deleting item become parent's next item
                // cus there is no right child
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                // if deleting item is the left child of parent
                // left child of deleting item become parent's left child
                // cus only have left child
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which we were looking at the root of the tree,
                // we want to delete root of the tree
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            // no left tree, so make parent point to right tree which may be null
            // maybe only have right child

            if (parent.next() == item) {
                // item is right child of its parent
                // right child of deleting item become parent's right child
                // cus there is no left child
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                // item is left child of parent
                // deleting item's right child become parent's left child
                // cus deleting item have no left child
                parent.setPrevious(item.next());
            } else {
                // again we are deleting root
                // neither left nor right child of parent is deleting item
                // then deleting item is root
                this.root = item.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier!
            // From the right subtree, find the smallest value (i.e., the leftmost).

            ListItem current = item.next();
            ListItem leftmostParent = item;

            // find the smallest value, moving to the left subtree until previous == null
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous(); // smallest value at the end of the loop
            }

            // Now put the smallest value
            // (the smallest left child of deleting item)
            // into our node to be deleted
            // replace deleted node's value with the smallest left child
            item.setValue(current.getValue());

            //and delete the smallest
            if (leftmostParent == item) {
                // next node to the deleted node has no previous
                // that is why leftmostNode=item and current=item.next()
                // set deleted item's next leftmostParent's right child
                item.setNext(current.next());
            } else {
                // leftmostParent's left child point null
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        // recursive function
        if (root != null) {
            traverse(root.previous()); // traverse left subtree

            System.out.println(root.getValue()); // when we got null,
            // print the value of the root

            traverse(root.next()); // move to right subtree, traverse right subtree
        }
    }
}
