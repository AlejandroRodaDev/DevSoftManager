package dataBase;

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
        public void disconnect() {
            Hibernate.closeSessionFactory();
            conectado=false;
        }

        /**
         * Método que conecta a la base de datos
         */
        public void connect() {
            Hibernate.buildSessionFactoryUser();
            conectado=true;
        }

        /**
         * Getter isConectado
         * @return conectado
         */
        public boolean isConnect() {
            return conectado;
        }

        /**
         * Setter setConectado
         * @param conectado
         */
        public void setConnect(boolean conectado) {
            this.conectado = conectado;
        }
    }

