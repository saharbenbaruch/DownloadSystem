public class File {
        int fileId;
        double fileSize;
        public File(int id, double size){
            fileId=id;
            fileSize=size;

        }

        public int getFileId() {
            return fileId;
        }

        public double getFileSize() {
            return fileSize;
        }



        public void print(){
            System.out.println("Watching file: "+ getFileId());
        }

    }
