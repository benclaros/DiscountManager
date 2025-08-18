package discountmanager;

public class Singleton {
    // Instancia estática de la clase
    private static Singleton instance;

    // Constructor privado para evitar instanciación externa
    private Singleton() {
        System.out.println("Instancia de Singleton creada.");
    }

    // Método estático para obtener la única instancia
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
