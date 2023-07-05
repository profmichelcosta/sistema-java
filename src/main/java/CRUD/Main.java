/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

public class Main {
    public static void main(String[] args) {
        CRUDOperations crud = new CRUDOperations();

        // Criar registro
        crud.create("João", 25);

        // Ler registros
        crud.read();

        // Atualizar registro
        crud.update("João", "José");

        // Excluir registro
        crud.delete("José");
    }
}

