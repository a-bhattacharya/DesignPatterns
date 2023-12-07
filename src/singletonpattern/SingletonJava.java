/**
 * Dealing with multithreading
 *
 * 1. Use synchronised getInstance() method
 * This is only relevant the first time because once the uniqueInstance variable is set, there is no need to synchronise
 * the method. This leads to overhead.
 *
 * 2. Move to eagerly created instance than lazily created one. Use this if the app will always use the Singleton or if
 * the overhead of creation and runtime aspects of the Singleton are not onerous.
 *
 * 3. Use double-checked locking. This is what the code uses. This allows to synchronise only the first time.
 */

package singletonpattern;

public class SingletonJava {
    private volatile static SingletonJava uniqueInstance;
    String state = this + " set";
    private SingletonJava() {
    }

    public static SingletonJava getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonJava.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonJava();
                }
            }
        }
        return uniqueInstance;
    }

    public String getState(){
        return state;
    }
}

//public class SingletonJavaWithHolder {
//
//    private SingletonJavaWithHolder() {
//        String state = "set";
//    }
//
//    private static final class UniqueInstanceHolder {
//        private static final SingletonJavaWithHolder uniqueInstance = new SingletonJavaWithHolder();
//    }
//
//    public static SingletonJavaWithHolder getInstance() {
//        return UniqueInstanceHolder.uniqueInstance;
//    }
//}
