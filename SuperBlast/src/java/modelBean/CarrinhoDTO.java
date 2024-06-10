/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelBean;

/**
 *
 * @author Eduardo Consani
 */
public class CarrinhoDTO {
    private int id_carrinho;
            private int fk_produto;
                    private int fk_usuario;

    public CarrinhoDTO() {
    }

    public CarrinhoDTO(int id_carrinho, int fk_produto, int fk_usuario) {
        this.id_carrinho = id_carrinho;
        this.fk_produto = fk_produto;
        this.fk_usuario = fk_usuario;
    }

    public int getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(int id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public int getFk_produto() {
        return fk_produto;
    }

    public void setFk_produto(int fk_produto) {
        this.fk_produto = fk_produto;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
                    
                    
}
