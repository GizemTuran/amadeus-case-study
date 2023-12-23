package backendjava.amadeuscasestudy.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class InvalidTimeException extends Exception{
    private String message;
}
