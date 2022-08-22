package access.modifiers;

/**
 * Challenge:
 *  In the following interface declaration, what is the visible of:
 *  1. the Accessible interface?
 *  2. the int variable SOME_CONSTANT?
 *  3. methodA?
 *  4. methodB and methodC?
 *  Hint: think back to the lecture in interface before answering
 */

// package-private: only visible inside access.modifier package
interface Accessible {
    // is public, cus all interface variable are public static final
    int SOME_CONSTANT = 100;

    // access modifier doesn't imply interface, all the method are public abstract
    public void methodA();

    // interface methods are default public
    void methodB();

    // public
    boolean methodC();
}
