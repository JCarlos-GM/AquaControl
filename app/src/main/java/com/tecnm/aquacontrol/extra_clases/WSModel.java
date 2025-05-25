package com.tecnm.aquacontrol.extra_clases;

public class WSModel {
    private String type;
    private int device_type;
    private String device_id;
    private Data data;

    public WSModel() {
    }

    public WSModel(String type, String device_id, int device_type, Data data) {
        this.device_type = device_type;
        this.type = type;
        this.device_id = device_id;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
         private int tds;
        private int ultrasonico;
        private int calidad;
        private int caudalimetro;
        private int temperatura;
        private int sistems_vacia;

        public int getTds() {
            return tds;
        }

        public void setTds(int tds) {
            this.tds = tds;
        }

        public int getUltrasonico() {
            return ultrasonico;
        }

        public void setUltrasonico(int ultrasonico) {
            this.ultrasonico = ultrasonico;
        }

        public int getCalidad() {
            return calidad;
        }

        public void setCalidad(int calidad) {
            this.calidad = calidad;
        }

        public int getCaudalimetro() {
            return caudalimetro;
        }

        public void setCaudalimetro(int caudalimetro) {
            this.caudalimetro = caudalimetro;
        }

        public int getTemperatura() {
            return temperatura;
        }

        public void setTemperatura(int temperatura) {
            this.temperatura = temperatura;
        }

        public int getSistems_vacia() {
            return sistems_vacia;
        }

        public void setSistems_vacia(int sistems_vacia) {
            this.sistems_vacia = sistems_vacia;
        }
    }
}
