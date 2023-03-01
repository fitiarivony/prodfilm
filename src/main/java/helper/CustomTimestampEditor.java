/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author FITIA ARIVONY
 */
import java.text.SimpleDateFormat;
import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import org.springframework.util.StringUtils;


public class CustomTimestampEditor extends PropertyEditorSupport {
    private final SimpleDateFormat dateFormat;
    private final boolean allowEmpty;

    public CustomTimestampEditor(SimpleDateFormat dateFormat, boolean allowEmpty) {
        this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (this.allowEmpty && !StringUtils.hasText(text)) {
            setValue(null);
        } else {
            try {
                setValue(new Timestamp(this.dateFormat.parse(text).getTime()));
            } catch (ParseException ex) {
                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
            }
        }
    }

    @Override
    public String getAsText() {
        Timestamp value = (Timestamp) getValue();
        return (value != null ? this.dateFormat.format(value) : "");
    }
}
