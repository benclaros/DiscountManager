package controller;

import command.Command;

public class CartControler {
    public void addProductToCart(Command command) { command.execute(); }
    public void removeProductFromCart(Command command) { command.execute(); }
}
