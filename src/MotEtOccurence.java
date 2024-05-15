
    public class MotEtOccurence{
        protected String mot ;
        protected int occurence ;

        public MotEtOccurence(String mot,int occurence ){
            this.mot=mot;
            this.occurence=occurence;
        }

        //getters and setters
         String getMot(){
           return mot;
        }
        protected int getOccurence(){
           return occurence;
        }
        protected void setOccurence(int occurence) {
            this.occurence = occurence;
        }

        @Override
        public String toString() {
            return mot + ":"+ occurence;
        }
        public boolean equals(Object anObject){
            if(anObject instanceof MotEtOccurence){
                return this.mot.toLowerCase().equals (((MotEtOccurence) anObject).mot.toLowerCase());
            }
            return false ;
        }
    }
