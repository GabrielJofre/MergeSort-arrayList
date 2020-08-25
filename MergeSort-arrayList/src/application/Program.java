package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Records;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Records> list = new ArrayList<>();

		System.out.println("Quantos cadastros deseja realizar?");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			int rg = (int) (100000 + Math.random() * 899999);

			while (checkRg(rg, list)) {
				rg = sc.nextInt();
			}
			System.out.print("RG:" + rg);

			sc.nextLine();
			System.out.print("Informe um nome: ");
			String name = sc.nextLine();

			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
			String formattedDate = format.format(date);
			System.out.print("Data: " + formattedDate);
			String data = formattedDate;

			list.add(new Records(rg, name, data));

			sc.nextLine();
		}

		System.out.println("\n Lista original: ");
		showList(list);

		mergeSort(list);
		System.out.println("\n Lista ordenada com merge sort: ");
		showList(list);
		sc.close();
	}

	public static boolean checkRg(int rg, List<Records> list) {
		Records result = list.stream().filter(x -> x.getRg() == rg).findFirst().orElse(null);
		return result != null;
	}

	public static void showList(List<Records> list) {
		for (Records rec : list) {
			System.out.println(rec.toString());
		}
	}

	public static void mergeSort(List<Records> list) {
		if (list.size() < 2) {
			return;
		}
		int mid = list.size() / 2;
		List<Records> left = new ArrayList<Records>(list.subList(0, mid));
		List<Records> right = new ArrayList<Records>(list.subList(mid, list.size()));

		mergeSort(left);
		mergeSort(right);
		merge(left, right, list);
	}

	public static void merge(List<Records> left, List<Records> right, List<Records> list) {

		int leftIndex = 0;
		int rightIndex = 0;
		int listIndex = 0;

		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(leftIndex).getRg() < right.get(rightIndex).getRg()) {
				list.set(listIndex++, left.get(leftIndex++));
			} else {
				list.set(listIndex++, right.get(rightIndex++));
			}
		}
		while (leftIndex < left.size()) {
			list.set(listIndex++, left.get(leftIndex++));
		}
		while (rightIndex < right.size()) {
			list.set(listIndex++, right.get(rightIndex++));
		}

	}
}