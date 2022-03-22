public class BPIS implements Predmet{
    
    private float pointsFromExercise = 0;
    private float pointsFromFinalExam = 0;
    private boolean credit = false;

    @Override
	public String getName() {
		return "BPC1";
	}

    @Override
    public float getPoints() {
        return pointsFromExercise + pointsFromFinalExam;
    }

    @Override
    public boolean getCredit() {
        return credit;
    }
    
    public void setCredit(boolean credit) {
        this.credit = credit;
    }
}
