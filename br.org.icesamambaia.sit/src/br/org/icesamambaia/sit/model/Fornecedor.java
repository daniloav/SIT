package br.org.icesamambaia.sit.model;
/**
 *
 * @author Danilo
*/
public class Fornecedor {
    private int idFornecedor;
    private String nomeFornecedor;
    private String cnpjFornecedor;
    private String descFornecedor;

    /**
     * @return the idFornecedor
     */
    public int getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * @param idFornecedor the idFornecedor to set
     */
    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     * @return the nomeFornecedor
     */
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    /**
     * @param nomeFornecedor the nomeFornecedor to set
     */
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    /**
     * @return the cnpjFornecedor
     */
    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    /**
     * @param cnpjFornecedor the cnpjFornecedor to set
     */
    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    /**
     * @return the descFornecedor
     */
    public String getDescFornecedor() {
        return descFornecedor;
    }

    /**
     * @param descFornecedor the descFornecedor to set
     */
    public void setDescFornecedor(String descFornecedor) {
        this.descFornecedor = descFornecedor;
    }
    
}
