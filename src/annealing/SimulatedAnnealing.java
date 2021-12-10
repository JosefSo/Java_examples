package annealing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class SimulatedAnnealing {

    // Calculate the acceptance probability
    public static double acceptanceProbability(double energy, double newEnergy, double temperature) {
        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void main(String[] args) {
        // Create and add our cities
        City city = new City(60, 200);
        TourManager.addCity(city);
        City city2 = new City(180, 200);
        TourManager.addCity(city2);
        City city3 = new City(80, 180);
        TourManager.addCity(city3);
        City city4 = new City(140, 180);
        TourManager.addCity(city4);
        City city5 = new City(20, 160);
        TourManager.addCity(city5);
        City city6 = new City(100, 160);
        TourManager.addCity(city6);
        City city7 = new City(200, 160);
        TourManager.addCity(city7);
        City city8 = new City(140, 140);
        TourManager.addCity(city8);
        City city9 = new City(40, 120);
        TourManager.addCity(city9);
        City city10 = new City(100, 120);
        TourManager.addCity(city10);
        City city11 = new City(180, 100);
        TourManager.addCity(city11);
        City city12 = new City(60, 80);
        TourManager.addCity(city12);
        City city13 = new City(120, 80);
        TourManager.addCity(city13);
        City city14 = new City(180, 60);
        TourManager.addCity(city14);
        City city15 = new City(20, 40);
        TourManager.addCity(city15);
        City city16 = new City(100, 40);
        TourManager.addCity(city16);
        City city17 = new City(200, 40);
        TourManager.addCity(city17);
        City city18 = new City(20, 20);
        TourManager.addCity(city18);
        City city19 = new City(60, 20);
        TourManager.addCity(city19);
        City city20 = new City(160, 20);
        TourManager.addCity(city20);

        // Set initial temp
        double temp = 10000;

        // Cooling rate
        double coolingRate = 0.003;

        // Initialize intial solution
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();

        System.out.println("Initial solution distance: " + currentSolution.getDistance());

        // Set as current best
        Tour best = new Tour(currentSolution.getTour());

        // Loop until system has cooled
        while (temp > 1) {
            // Create new neighbour tour
            Tour newSolution = new Tour(currentSolution.getTour());

            // Get a random positions in the tour
            int tourPos1 = (int) (newSolution.tourSize() * Math.random());
            int tourPos2 = (int) (newSolution.tourSize() * Math.random());

            // Get the cities at selected positions in the tour
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            // Swap them
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);

            // Get energy of solutions
            double currentEnergy = currentSolution.getDistance();
            double neighbourEnergy = newSolution.getDistance();

            // Decide if we should accept the neighbour
            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                currentSolution = new Tour(newSolution.getTour());
            }

            // Keep track of the best solution found
            if (currentSolution.getDistance() < best.getDistance()) {
                best = new Tour(currentSolution.getTour());
            }

            // Cool system
            temp *= 1-coolingRate;
        }

        System.out.println("Final solution distance: " + best.getDistance());
        System.out.println("Tour: " + best);

        final Tour tour = best;

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(tour);
            }
        });
    }

    private static void createAndShowGUI(Tour tour) {

        JFrame f = new JFrame("Annealing simulation for TSP");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myPanel = new MyPanel(tour);

        f.add(myPanel);
        f.pack();
        f.setVisible(true);
    }
}

//http://docs.oracle.com/javase/tutorial/uiswing/painting/step3.html

class MyPanel extends JPanel {

    private static final long serialVersionUID = 7615629084996272465L;

    // if you want to increase the picture of the route, increase the koef
    float koef = 1.8f;

    // pagging/margin of the route image
    int offset = 50;

    // default area size, our coordinates are within range 0-200
    int areaSize = 200;

    private Tour tour;

    public MyPanel(Tour tour) {

        setBorder(BorderFactory.createLineBorder(Color.black));
        this.tour = tour;

    }

    private void showTour(Graphics g){

        // number of the current city in the route, starts at 1
        // for the first city we don't draw a line to the prev city
        int number = 1;

        int prevX = 0, prevY = 0;

        int max = (int)(offset + areaSize*koef);

        for (City city: tour.getTour()) {

            g.setColor(Color.BLUE);

            g.drawString(
                    String.valueOf(number),
                    offset + (int)((city.getX() - 5)*koef),
                    max - (int)((city.getY()+ 5 )*koef));

            g.setColor(Color.RED);

            if (number == 1) {
                prevX = city.getX();
                prevY = city.getY();

            } else {

                g.drawLine((int)(prevX*koef + offset), (int)(max - prevY*koef),
                        (int)(city.getX()*koef) + offset, max - (int)(city.getY()*koef));
                prevX = city.getX();
                prevY = city.getY();
            }
            number++;
        }
    }

    public Dimension getPreferredSize() {
        // we define the size of the window dynamically
        return new Dimension((int)(offset*2 + areaSize*koef), (int)(offset*2 + areaSize*koef));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Resulting route, length = " + String.valueOf(tour.getDistance()),10,20);

        g.setColor(Color.BLACK);

        g.drawRect(offset, offset , (int)(areaSize*koef), (int)(areaSize*koef));

        int step = (int)(areaSize*koef/20);

        // creating grid
        for (int i = 1; i < 20 ; i++){
            g.drawLine(offset - 5, i*step + offset, offset + 5 + (int)(areaSize*koef), i*step + offset);
            g.drawLine(offset + i*step, offset - 5, offset + i*step, offset + 5 + (int)(areaSize*koef));
        }

        showTour(g);
    }

}
