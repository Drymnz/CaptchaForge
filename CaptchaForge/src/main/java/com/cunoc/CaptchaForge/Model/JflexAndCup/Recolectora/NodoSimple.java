package com.cunoc.CaptchaForge.Model.JflexAndCup.Recolectora;

public class NodoSimple<T> {

    T valor;
    NodoSimple<T> left;
    NodoSimple<T> right;

    public NodoSimple(T valor) {
        this.valor = valor;
        this.left = null;
        this.right = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoSimple<T> getLeft() {
        return left;
    }

    public void setLeft(NodoSimple<T> left) {
        this.left = left;
    }

    public NodoSimple<T> getRight() {
        return right;
    }

    public void setRight(NodoSimple<T> right) {
        this.right = right;
    }

    public void addNodoSimpleRight(NodoSimple<T> right){
        if (this.right != null) {
            this.right.addNodoSimpleRight(right);
        } else {
            this.right = right;
        }
    }

}
