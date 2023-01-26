package Patent.BackendPatent.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMLListaDTO")
public class XMLListaDTO {
    private String[]lista;

    public XMLListaDTO() {
    }

    public String[] getLista() {
        return lista;
    }

    public void setLista(String[] lista) {
        this.lista = lista;
    }

    public XMLListaDTO(String[] lista) {
        this.lista = lista;
    }
}
