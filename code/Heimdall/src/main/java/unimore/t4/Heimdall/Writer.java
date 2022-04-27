    package com.demoproject.maven_demo;

    import java.util.Map;

    public class Writer {

        final Map<String, Object> mappajson ;

        //costruttore
        public Writer (Map<String, Object> mappajson){

            this.mappajson = mappajson;

        }

        // scriviamo un metodo di ritorno per ogni campo del json che si trova nella hashmap

        public String request (){
            return (String) this.mappajson.get("request");
        }

        public String MONTH (){
            return (String) this.mappajson.get("MONTH");
        }

        public String agent (){
            return (String) this.mappajson.get("agent");
        }

        public String COMMONAPACHELOG (){
            return (String) this.mappajson.get("COMONAPACHELOG");
        }

        public String auth (){
            return (String) this.mappajson.get("auth");
        }

        public String HOUR (){
            return (String) this.mappajson.get("HOUR");
        }

        public String ident (){
            return (String) this.mappajson.get("ident");
        }


        public String verb (){
            return (String) this.mappajson.get("verb");
        }


        public String TIME (){
            return (String) this.mappajson.get("TIME");
        }

        public String INT (){
            return (String) this.mappajson.get("INT");
        }

        public String referrer (){
            return (String) this.mappajson.get("referrer");
        }

        public String YEAR (){
            return (String) this.mappajson.get("YEAR");
        }


        public String response (){
            return (String) this.mappajson.get("response");
        }

        public String bytes (){
            return (String) this.mappajson.get("bytes");
        }

        public String clientip (){
            return (String) this.mappajson.get("clientip");
        }

        public String COMBINEDAPACHELOG (){
            return (String) this.mappajson.get("COMBINEDAPACHELOG");
        }

        public String MINUTE (){
            return (String) this.mappajson.get("MINUTE");
        }

        public String SECOND (){
            return (String) this.mappajson.get("SECOND");
        }

        public String httpversion (){
            return (String) this.mappajson.get("httpversion");
        }

        public String rawrequest (){
            return (String) this.mappajson.get("rawrequest");
        }

        public String MONTHDAY (){
            return (String) this.mappajson.get("MONTHDAY");
        }

        public String timestamp (){
            return (String) this.mappajson.get("timestamp");
        }

    }
