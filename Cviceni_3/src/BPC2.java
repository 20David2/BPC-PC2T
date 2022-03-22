public class BPC2 implements Predmet {
    
    private float pointsFromExam = 0;
    private float pointsFromProject = 0;
    private float pointsFromFinalExam = 0;

    @Override
	public String getName() {
		return "BPC1";
	}

    @Override
    public float getPoints() {
        return pointsFromExam + pointsFromProject + pointsFromFinalExam;
    }

    @Override
    public boolean getCredit() {
        if(pointsFromExam + pointsFromProject >= PointsForCredit)
        return true;
        else
        return false;
    }

    public boolean setPointsFromExam(float points)
    {
        if(points <= 20 ) {
            pointsFromExam = points;
            return true;
        }
        else
        return false;
        
    }

    public boolean setPointsFromProject(float points)
    {
        if(points <= 30 ) {
            pointsFromProject = points;
            return true;
        }
        else
        return false;
        
    }


    public boolean setPointsFromFinalExam(float points)
    {
        if(points <= 50 ) {
            pointsFromFinalExam = points;
            return true;
        }
        else
        return false;
        
    }
    
}
