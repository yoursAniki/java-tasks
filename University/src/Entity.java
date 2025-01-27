import java.lang.reflect.Field;
import annotation.ToString;

public abstract class Entity {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Class<?> currentClass = this.getClass();

        ToString classAnnotation = currentClass.getAnnotation(ToString.class);
        boolean excludeAllFields = classAnnotation != null && classAnnotation.value() == ToString.Value.NO;

        result.append(currentClass.getSimpleName()).append(" {");

        boolean firstField = true;

        while (currentClass != null && currentClass != Object.class) {
            Field[] fields = currentClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);

                ToString fieldAnnotation = field.getAnnotation(ToString.class);

                boolean includeField = (!excludeAllFields && (fieldAnnotation == null || fieldAnnotation.value() == ToString.Value.YES))
                        || (excludeAllFields && fieldAnnotation != null && fieldAnnotation.value() == ToString.Value.YES);

                if (includeField) {
                    try {
                        if (!firstField) {
                            result.append(", ");
                        }
                        result.append(field.getName()).append("=").append(field.get(this));
                        firstField = false;
                    } catch (IllegalAccessException e) {
                        result.append(field.getName()).append(": null");
                    }
                }
            }

            currentClass = currentClass.getSuperclass();
        }

        result.append("}");
        return result.toString();
    }
}
