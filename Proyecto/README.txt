Nombre Completo: Eduardo Alejandro Sánchez Moya
Respuestas a las Preguntas (Práctica 5, Sección 2) 
---

1. ¿Por qué eligieron esta opción? 
   Elegí la Versión 3 (Genéricos) porque ofrece la combinación ideal de reutilización de código y seguridad de tipos (type-safety). A diferencia de la Versión 2 (Object), no requiere conversiones (casting) manuales, lo que previene errores en tiempo de ejecución. A diferencia de la Versión 1 (Sobrecarga), no se necesita duplicar métodos para cada tipo de usuario (Administrador, Empleado, etc.), lo que hace el código más "limpio y mantenible".

2. De las tres opciones, ¿cuál brinda mayor escalabilidad y por qué? 
   La Versión 3 (Genéricos) brinda por mucho la mayor escalabilidad. Si en el futuro se créase una nueva clase que herede de "Usuario" (por ejemplo "Invitado" y/o "SoporteTecnico" el "ManejadorLista<T>" funcionará con esa nueva clase sin necesidad de modificar una sola línea de su código. Simplemente se instanciaría como "ManejadorLista<Invitado>". Ni la Sobrecarga (requeriría un nuevo método) ni "Object" (perdería la información del tipo específico) ofrecen esta flexibilidad.

3. ¿Cuáles son las principales ventajas de la opción que seleccionaste para implementar? 
   Seguridad de Tipos (Type Safety): El compilador de Java verifica en tiempo de compilación que solo se usen los tipos correctos. Si intentáse revertir una lista de "Administrador" usando un "ManejadorLista<Empleado>", el programa no compilaría, previniendo errores.
   Reutilización de Código: Se escríbe la lógica para "revertir" una sola vez dentro de "ManejadorLista<T>", y esa misma lógica funciona para "T=Administrador", "T=Empleado" o cualquier otro tipo.
   Código Limpio: No hay necesidad de "instanceof" o casting explícito, lo que hace el código más legible y menos propenso a errores "ClassCastException".

4. ¿Qué desventajas o limitaciones identificas en la opción que implementaste? 
   Complejidad Inicial: El concepto de genéricos es más "abstracto" de entender en comparación con la sobrecarga de métodos.
   Type Erasure (Borrado de Tipo): Debido a la forma en la que Java implementa genéricos en tiempo de ejecución, el tipo "T" se "borra", lo que impone algunas limitaciones. Por ejemplo, no se puede hacer "new T[10]" directamente dentro de la clase genérica (aunque en mi caso no fue necesario). Sin embargo, para esta práctica, las ventajas superan por mucho estas limitaciones.