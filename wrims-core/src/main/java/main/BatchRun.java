package main;

import wrimsv2.components.ControllerBatch;

public class BatchRun {

	public static void main(String[] args) {
		if((new ControllerBatch(args)).isRunCompleted()) {
			System.exit(0);
		} else {
			System.exit(1);
		}
	}	
}
