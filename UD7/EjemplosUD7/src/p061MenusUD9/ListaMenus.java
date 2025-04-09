package p061MenusUD9;


import java.util.ArrayList;

public class ListaMenus {
 
    ArrayList<Menu> miListaMenus = new ArrayList();
    
    public void anadirMenu (Menu f) {
        miListaMenus.add(f);
    }
    
    public int numeroMenus() {
        return miListaMenus.size();
    }
    
    public Menu MenuPosicionI(int i) {
        return miListaMenus.get(i);
    }
    
    public boolean contieneMenu (Menu a) {
        return (miListaMenus.contains(a));
    }
    
    public void mostrarMenus() {
        for (Menu m : miListaMenus) {
            System.out.println(m);
        }
    }

    @Override
    public String toString() {
        return "ListaMenus{" + miListaMenus + '}';
    }
    
    
    
}