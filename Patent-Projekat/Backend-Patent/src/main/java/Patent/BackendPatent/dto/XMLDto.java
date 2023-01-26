package Patent.BackendPatent.dto;

public class XMLDto {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public XMLDto() {
    }

    public XMLDto(String text) {
        this.text = text;
    }
}
