package extractor.parser;

import extractor.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ASTParser {
    private static final String CLASS_ANONYMOUS = "[anonymous]";

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
        JavaProject project = new JavaProject();

        for(File javaFile : loadASTFiles(astFolderPath)) {
            Document xmlDoc = builder.parse(javaFile);
            ConcreteClass clazz = parseClass(null, (Element)xmlDoc.getElementsByTagName(TAG_CLASS).item(0));
            project.addClass(clazz);
        }

        return project;
    }

    private static ConcreteClass parseClass(String parentClassName, Element classElement) {
        String className;
        if(parentClassName != null && parentClassName.endsWith(CLASS_ANONYMOUS)) {
            className = parentClassName;
        } else {
            className = classElement.getAttribute(ATTR_CLASS_NAME);
            if(parentClassName != null)
                className = parentClassName + "." + className;
        }
        ConcreteClass clazz = new ConcreteClass(className);
        List<ClassElement> elements = new ArrayList<>();

        NodeList innerClasses = classElement.getElementsByTagName(TAG_CLASS);
        for(int i = 0; i < innerClasses.getLength(); ++i)
            ;//elements.add(parseClass(className, (Element) innerClasses.item(i)));

        NodeList fields = classElement.getElementsByTagName(TAG_FIELD);
        for(int i = 0; i < fields.getLength(); ++i)
            ;//elements.add(parseVariable((Element) fields.item(i)));

        NodeList methods = classElement.getElementsByTagName(TAG_METHODS);
        for(int i = 0; i < methods.getLength(); ++i)
            ;//elements.add(parseMethod((Element) methods.item(i)));

        //clazz.addElements(elements);
        return clazz;
    }

    private static ConcreteMethod parseMethod(Element methodElement) {
        String name = methodElement.getAttribute(ATTR_METHOD_NAME);
        ConcreteMethod method = new ConcreteMethod(name);
        List<ClassElement> elements = new ArrayList<>();

        NodeList anonymousClasses = methodElement.getElementsByTagName(TAG_CLASS);
        for(int i = 0; i < anonymousClasses.getLength(); ++i)
            ;//elements.add(parseClass(name + "." + CLASS_ANONYMOUS, (Element) anonymousClasses.item(i)));

        NodeList localVars = methodElement.getElementsByTagName(TAG_VARIBLE);
        for(int i = 0; i < localVars.getLength(); ++i)
            ;//elements.add(parseVariable((Element) localVars.item(i)));

        //method.addVariables(elements);
        return method;
    }

    private static ConcreteVariable parseVariable(Element variableElement) {
        String name = variableElement.getAttribute(ATTR_VAR_NAME);
        return new ConcreteVariable(name);
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
