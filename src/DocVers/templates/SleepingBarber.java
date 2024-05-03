package DocVers.templates;

import java.util.Vector;

public class SleepingBarber {
    public static class Barbershop{
        Barber barber;
        Vector<Client> clients;

        public Barbershop() {
            barber = new Barber(this);
        }

        public void addClient(Client client){
            clients.add(client);
        }
        public boolean hasClients(){
            return !clients.isEmpty();
        }
    }

    public static class Client implements Runnable{
        final Barbershop barbershop;

        public Client(Barbershop barbershop) {
            this.barbershop = barbershop;
        }

        @Override
        public void run() {
            barbershop.addClient(this);
        }
    }

    public static class Barber implements Runnable {

        final Barbershop barbershop;
        public Barber(Barbershop barbershop) {
            this.barbershop = barbershop;
        }

        @Override
        public void run() {
            while (true){
                while (barbershop.hasClients()){
                    Client client = barbershop.clients.get(0);
                    System.out.println("Barber is shaving");
                    barbershop.clients.remove(client);
                    System.out.println(barbershop.clients.size() + " clients left");
                }
                System.out.println("barber goes asleep");
                try { this.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
    public static class ClientFactory{

    }

    public static void main(String[] args) {

    }
}
