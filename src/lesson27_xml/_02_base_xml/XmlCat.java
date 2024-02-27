package lesson27_xml._02_base_xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class XmlCat {
    private int id;
    private String name;
    private int age;
}
