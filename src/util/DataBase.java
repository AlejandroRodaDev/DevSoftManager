package util;

public class DataBase {
    /**
     * Clase DataBase.
     * Contiene los métodos de la base de datos
     */
    public class DataBaseUtil {

        private boolean conectado;

        /**
         * Constructor
         */
        public DataBaseUtil() {
        }

        /**
         * Método que desconecta de la base de datos
         */
        public void desconectar() {
            //HibernateUtil.closeSessionFactory();
            conectado=false;
        }

        /**
         * Método que conecta a la base de datos
         */
        public void conectar() {
            conectado=true;
        }

        /**
         * Getter isConectado
         * @return conectado
         */
        public boolean isConectado() {
            return conectado;
        }

        /**
         * Setter setConectado
         * @param conectado
         */
        public void setConectado(boolean conectado) {
            this.conectado = conectado;
        }
    }
}

