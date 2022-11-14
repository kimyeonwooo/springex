package net.ict.springex.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {
    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // date 타입 formatter 형태로 바꾸겟다는 의미 .ofPattern("yyyy-MM-dd") 이런 식으로 출력하도록 포맷을 지정하겠다
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
        // 작성 후 서플릿 빈이므로 servlet-context에 등록해줘야함
    }
}
