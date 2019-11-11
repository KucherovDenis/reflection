package ru.rzn.sbt.javaschool.reflection.base;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Демонстрация основных возможностей рефлексии.
 */
public class ClassAnalyzer {
    public static final String TEST_STRING = "testString";

    private static void getAllSuperclass(Class clazz, List<Class> classes) {
        Class superClass = clazz.getSuperclass();
        if (superClass != Object.class) {
            classes.add(superClass);
            getAllSuperclass(superClass, classes);
        }
    }

    private static void getAllInterfaces(Class clazz, Map<String, List<Class>> mapInterfaces) {
        Class[] interfaces = clazz.getInterfaces();
        List<Class> list = new ArrayList<Class>(Arrays.asList(interfaces));
        mapInterfaces.put(clazz.getName(), list);
        Class superClass = clazz.getSuperclass();
        if (superClass != Object.class) {
            getAllInterfaces(superClass, mapInterfaces);
        }
    }

    public static void main(String[] args) {
        // Шаг 1
        // Рассмотрим стандартный спобос создания объекта
//        TheCat theCat = new TheCat();
//        System.out.println("Голос по умолчанию: " + theCat.getVoice());
//
//        // на текущий момент у нас некий экземпляр класса, и из него мы можем понять какой класс перед нами
//        Class classFromObject = theCat.getClass();
//        Class  classFromClass = TheCat.class;
//
//        // получение имени класса
//        String className = classFromObject.getName();
//        String classNameFromKey = classFromClass.getName();
//        String classNameString = TEST_STRING.getClass().getName();
//
//        System.out.println("Полученное имя для класса нашего объекта: " + className);
//        System.out.println("Полученное имя для класса через class: " + classNameFromKey);
//        System.out.println("Полученное имя для стандартного класса: " + classNameString);
//        System.out.println();

//        // Шаг 2
//        // Рассмотрим второй способ создания объекта
//        try {
//            Class classFromName = Class.forName("ru.rzn.sbt.javaschool.reflection.base.TheCat");
//            System.out.println("Полученное имя для theCatClass: " + classFromName.getName());
//
////            System.out.println("Голос по умолчанию: " + classFromName.getVoice());
//            TheCat theCatClassInstance = (TheCat) classFromName.newInstance();
//            System.out.println("Голос по умолчанию: " + theCatClassInstance.getVoice());
//            System.out.println();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }

//        // Шаг 3
//        // Получение модификаторов доступа для класса
//        int classModifiers = TheCat.class.getModifiers();
//        if (Modifier.isPublic(classModifiers)) {
//            System.out.println("Класс TheCat имеет модификатор public");
//        }
//        if (Modifier.isAbstract(classModifiers)) {
//            System.out.println("Класс TheCat имеет модификатор abstract");
//        }
//        if (Modifier.isFinal(classModifiers)) {
//            System.out.println("Класс TheCat имеет модификатор final");
//        }

//        // Шаг 4
//        // Получение суперклассов
//        Class superclass = TheCat.class.getSuperclass();
//        System.out.println("Класс TheCat имеет суперкласс: " + superclass);

        List<Class> classes = new ArrayList<Class>();
        getAllSuperclass(TheCat.class, classes);
        System.out.println("Класс TheCat имеет дерево наследования:");
        for (Class cl : classes) {
            System.out.println(cl.getName());
        }
//        // Шаг 5
//        // Получение интерфейсов
//        Class[] interfaces = TheCat.class.getInterfaces();
//        for (Class cInterface : interfaces) {
//            System.out.println("Класс TheCat реализует: " + cInterface.getName());
//        }

        Map<String, List<Class>> interfacesMap = new HashMap<String, List<Class>>();
        getAllInterfaces(TheCat.class, interfacesMap);
        for (Map.Entry<String, List<Class>> entry : interfacesMap.entrySet()) {
            System.out.println(String.format("Класс %s наследует интерфейсы:", entry.getKey()));
            for (Class clInterface : entry.getValue()) {
                System.out.println("\t" + clInterface.getName());
            }
        }
//        // Шаг 6
        // Получение полей класса
//        Field[] publicFields = TheCat.class.getFields();
//        for (Field field : publicFields) {
//            Class fieldType = field.getType();
//            System.out.println("Имя поля: " + field.getName());
//            System.out.println("Тип поля: " + fieldType.getName());
//            System.out.println();
//        }
//
//
//        Field[] declaredFields = TheCat.class.getDeclaredFields();
//        for (Field field : declaredFields) {
//            Class fieldType = field.getType();
//            System.out.println("Имя поля: " + field.getName());
//            System.out.println("Тип поля: " + fieldType.getName());
//            System.out.println();
//        }

//        // Получеине поле класса
//        try {
//            Field publicField = TheCat.class.getDeclaredField("eyesColor");
//            System.out.printf(publicField.getName());
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }

        try {
            Field field = TheCat.class.getField("eyesColor");
            field.setAccessible(true);
            TheCat cat = new TheCat();
            field.set(cat, "черный");
            System.out.println(cat.getEyesColor());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

//        // Шаг 7
//        // Получение конструктора
//        Constructor[] constructors = TheCat.class.getConstructors();
//        for (Constructor constructor : constructors) {
//            System.out.print("Конструктор: " + constructor.getName() + "(");
//            Class[] paramTypes = constructor.getParameterTypes();
//            for (int i = 0; i < paramTypes.length; i++) {
//                System.out.print(paramTypes[i].getName());
//                if (i < paramTypes.length - 1) System.out.print(", ");
//            }
//            System.out.println(")");
//        }
//
//        // Получение конкретного конструктора
//        Class[] paramTypes = new Class[]{String.class, String.class};
//        try {
//            Constructor currentConstructor = TheCat.class.getConstructor(paramTypes);
//            System.out.printf("found");
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

//        // Шаг 8
//        // Изучение информации о методе
//        Method[] methods = TheCat.class.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println("Имя метода: " + method.getName());
//            int modifiers = method.getModifiers();
//            System.out.println(Modifier.isPublic(modifiers));
//            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());
//            Class[] methodParameterTypes = method.getParameterTypes();
//            System.out.print("Типы параметров: ");
//            for (Class paramType : methodParameterTypes) {
//                System.out.print(" " + paramType.getName());
//            }
//            System.out.println("\n");
//        }

//        // Шаг 9
//        // Получение конкретного метода и его выполнение
//        Class[] paramTypesM = new Class[]{String.class};
//        try {
//            Method m = TheCat.class.getMethod("setVoice", paramTypesM);
//            TheCat theCat = new TheCat();
//            m.invoke(theCat, "гав");
//            System.out.println(theCat.getVoice());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//
//        Class[] paramTypesM = new Class[]{int.class, String.class};
//        try {
//            Method m = TheCat.class.getMethod("methodA", paramTypesM);
//            m.invoke(TheCat.class, args);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }

}
