package util;

    /**
     * Clase DataBase.
     * Contiene los métodos de la base de datos
     */
    public class DataBase {

        private boolean conectado;

        /**
         * Constructor
         */
        public DataBase() {
        }

        /**
         * Método que desconecta de la base de datos
         */
        public void desconectar() {
            Hibernate.closeSessionFactory();
            conectado=false;
        }

        /**
         * Método que conecta a la base de datos
         */
        public void conectar() {
            Hibernate.buildSessionFactory();
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

