package com.sorsix.interns;

/**
 *
 * FACTORY DESIGN PATTERN
 *
 * When we need to create objects all across the app we can use design pattern
 * specified for that purpose which is creating certain type of objects for us.
 *
 * Problem with this design pattern is that in bigger app this factory classes
 * will become more bigger and complex for working with. So here comes the
 * DI (Dependency injection) Framework.
 *
 * DI framework works on principles of wiring (Autowiring) of dependencies of objects.
 * Beside object creation di framework is containing them in the container.
 * This is prevention in cases in which certain object will be used again(so when
 * object is once created, we have his track in the di container(also referred as IoC)).
 * There are more implementations of this framework and we are using Spring DI Framework.
 */
public class CarFactory {
    public enum EngineType {
        ELECTRIC,
        OTO
    }

    public static Car createCar(EngineType type, int power) {
        if (type == EngineType.OTO) {
            return new Car(new Transmission("auto"), new OtoEngine(power));
        } else {
            return new Car(new Transmission("auto"), new ElectricEngine(power));
        }
    }
}
