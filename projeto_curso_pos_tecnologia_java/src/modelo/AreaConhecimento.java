package modelo;

import java.util.concurrent.RecursiveTask;

public enum AreaConhecimento {

    PROGRAMACAO, FRONT_END, DATA_SCIENCE, DEVOPS, UX_DESIGN, MOBILE;

    public String retornaArea(AreaConhecimento areaConhecimento) {
        switch (areaConhecimento) {
            case PROGRAMACAO: {
                return "PROGRAMAÇÃO";
            } case FRONT_END: {
                return "FRONT-END";
            } case DATA_SCIENCE: {
                return "DATA SCIENCE";
            } case DEVOPS: {
                return "DEVOPS";
            } case UX_DESIGN: {
                return "UX & DESIGN";
            } case MOBILE: {
                return "MOBILE";
            } default: {
                return null;
            }
        }
    }
}
