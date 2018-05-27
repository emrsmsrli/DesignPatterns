package extractor.parser;

import extractor.project.JavaProject;
import extractor.project.elements.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ASTParser {
    private static final String TAG_CLASS = "ClassOrInterfaceDeclaration";
    private static final String TAG_FIELD = "FieldDeclaration";
    private static final String TAG_VARIBLE = "LocalVariableDeclaration";
    private static final String TAG_METHODS = "MethodDeclaration";

    private static final String ATTR_CLASS_NAME = "Image";
    private static final String ATTR_VAR_NAME = "VariableName";
    private static final String ATTR_METHOD_NAME = "MethodName";

    private static ASTParser INSTANCE = null;

    private final DocumentBuilder builder;

    private ASTParser() throws Exception {
        builder = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder();
    }

    public JavaProject generateProject(String astFolderPath) throws Exception {
        List<JavaClass> classes = new ArrayList<>();

        for(File javaFile : loadASTFiles(astFolderPath)) {
            Document xmlDoc = builder.parse(javaFile);
            JavaClass clazz = parseClass(null, (Element)xmlDoc.getElementsByTagName(TAG_CLASS).item(0));
            classes.add(clazz);
        }

        return new JavaProject(classes);
    }

    private static JavaClass parseClass(String parentName, Element CompositeComponent) {
        String name = CompositeComponent.getAttribute(ATTR_CLASS_NAME);
        if(parentName != null)
            name = parentName + "." + name;
        List<JavaElement> elements = new ArrayList<>();

        NodeList innerClasses = CompositeComponent.getElementsByTagName(TAG_CLASS);
        for(int i = 0; i < innerClasses.getLength(); ++i)
            elements.add(parseClass(name, (Element) innerClasses.item(i)));

        NodeList fields = CompositeComponent.getElementsByTagName(TAG_FIELD);
        for(int i = 0; i < fields.getLength(); ++i)
            elements.add(parseVariable(name, (Element) fields.item(i)));

        NodeList methods = CompositeComponent.getElementsByTagName(TAG_METHODS);
        for(int i = 0; i < methods.getLength(); ++i)
            elements.add(parseMethod(name, (Element) methods.item(i)));

        return new JavaClass(name, elements);
    }

    private static JavaMethod parseMethod(String parentName, Element methodElement) {
        String name = parentName + "." + methodElement.getAttribute(ATTR_METHOD_NAME) + "()";
        List<JavaElement> elements = new ArrayList<>();

        /*NodeList anonymousClasses = methodElement.getElementsByTagName(TAG_CLASS);
        for(int i = 0; i < anonymousClasses.getLength(); ++i)
            elements.add(parseClass((Element) anonymousClasses.item(i)));*/

        NodeList localVars = methodElement.getElementsByTagName(TAG_VARIBLE);
        for(int i = 0; i < localVars.getLength(); ++i)
            elements.add(parseVariable(name, (Element) localVars.item(i)));

        return new JavaMethod(name, elements);
    }

    private static JavaVariable parseVariable(String parentName, Element variableElement) {
        String name = parentName + "." + variableElement.getAttribute(ATTR_VAR_NAME);
        return new JavaVariable(name);
    }

    private File[] loadASTFiles(String path) {
        return new File(path).listFiles((dir, name) -> name.endsWith(".ast"));
    }

    public static ASTParser instance() throws Exception {
        if(INSTANCE == null)
            INSTANCE = new ASTParser();
        return INSTANCE;
    }
}
