package org;

import annotations.HtmlForm;
import annotations.HtmlInput;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.*;
import java.util.Set;

@SupportedAnnotationTypes({"annotations.HtmlForm" , "annotations.HtmlInput"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class HtmlProcessor extends AbstractProcessor {
    final String SUBMIT_BUTTON = "\t<input type = \"submit\" value = \"Send\">\n";
    final String FORM_CLOSE = "</form>\n";
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(HtmlForm.class)) {
            HtmlForm htmlForm = element.getAnnotation(HtmlForm.class);
            try (FileWriter fileWriter = new FileWriter("target/classes/" + htmlForm.filename())) {
                fileWriter.write(generateHtmlFormCode(htmlForm.action(), htmlForm.method()));
                for (Element e : element.getEnclosedElements()) {
                    HtmlInput htmlInput = e.getAnnotation(HtmlInput.class);
                    if (htmlInput != null) {
                        fileWriter.write(generateHtmlInputCode(htmlInput.type(), htmlInput.name(), htmlInput.placeholder()));
                    }
                }
                fileWriter.write(SUBMIT_BUTTON);
                fileWriter.write(FORM_CLOSE);
                fileWriter.flush();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private String generateHtmlFormCode(String action, String method) {
        return String.format("<form action = \"%s\" method = \"%s\">\n", action, method);
    }

    private String generateHtmlInputCode(String type, String name, String placeholder) {
        return String.format("\t<input type = \"%s\" name = \"%s\" placeholder = \"%s\">\n", type, name, placeholder);
    }

}

