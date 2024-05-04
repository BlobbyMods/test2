package org.cloudns.danng.adapters;

public class basic implements adapterInterface {

    private boolean enabled = true;

    @Override
    public void doSomething() {
        if (enabled) {
            // Implement functionality specific to this adapter
            System.out.println("MyAdapter is doing something.");
        } else {
            System.out.println(public class + "Is disabled");
        }
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("Disabled Adapter");
    }
}