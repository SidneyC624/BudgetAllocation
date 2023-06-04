import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("How much can you spend?");
		double total = scanner.nextDouble();
		double sum = 0;
		int i = 0;
		ArrayList<Double> proportion = new ArrayList<Double>();
		System.out.println("Enter your proportion for various expenses: ");
		System.out.println("The system stops once the cumulative proportion exceeds 100%");
		do {
			System.out.println("Enter the proportion (in %) of expense on item " + (i + 1) + " :");
			double value = scanner.nextDouble();
			proportion.add(value);
			sum += value;
			i++;
		}
		while(sum <= 100);
		scanner.close();
		
		if(sum > 100) {
			double cumulativeSum = 0;
			for(int k = 0; k < proportion.size()-1; k++) {
				cumulativeSum += proportion.get(k);
			}
			proportion.set(proportion.size()-1, 100 - cumulativeSum);
		}
		
		for(int j=0; j< proportion.size(); j++) {
			double expense = total * proportion.get(j) / 100;
			System.out.println(proportion.get(j) + "% of your expense, which is $" + expense + " goes to item " + (j+1) );
		}

	}

}
