package main.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import main.validators.TaryfaReqVSAdit;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
@RequiredArgsConstructor
@TaryfaReqVSAdit
public class Taryfa {
    private String id;
    @NotNull(message = "Taryfa musi się składać chociaż z jednego składnika")
    private final ArrayList<Liczydlo> liczydlaReq;
    private final ArrayList<Liczydlo> liczydlaAdit;
    @Size( min = 2, message = "Nazwa nie może być pusta")
    private final String nazwa;

}
