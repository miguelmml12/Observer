package aspects;

import observer.MainWindow;

public aspect ObserverAspect {
    after() : execution(void *.setBackground(java.awt.Color)) && within(observer.MainWindow) {
        java.awt.Container cont = (java.awt.Container) thisJoinPoint.getThis();
        java.awt.Color color = cont.getBackground();
        String colorName = getColorName(color);
        System.out.println("AspectJ detectó cambio de color a: " + colorName);
        MainWindow.subject.notifyAllObservers(colorName);
    }

    private String getColorName(java.awt.Color color) {
        if (color.equals(java.awt.Color.RED)) return "Rojo";
        if (color.equals(java.awt.Color.GREEN)) return "Verde";
        if (color.equals(java.awt.Color.BLUE)) return "Azul";
        return "Otro";
    }
}
