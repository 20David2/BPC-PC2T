public class BPC1 implements Predmet{

    private float pointsFromExercise = 0;
    private float pointsFromFinalExam = 0;

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
        if(pointsFromExercise >= PointsForCredit)
        return true;
        else
        return false;
    }

    public boolean addPointsFromExercise(float points)
    {
        if(pointsFromExercise + points <= 20 ) {
            pointsFromExercise += points;
            return true;
        }
        else
        return false;
        
    }

    public boolean setPointsFromFinalExam(float points)
    {
        if(points <= 80 ) {
            pointsFromFinalExam = points;
            return true;
        }
        else
        return false;
        
    }


}
