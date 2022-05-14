package com.risa.graphicinterface.graphstream;

public class Stylesheets {

    private String GraphStyle() {
        return """
                graph {
                padding: 50px;
                    fill-color: #88665D;
                }
                """;
    }

    private String NodeStyle() {
        return """
                node {
                    size: 20px;
                    fill-color: #119DA4;
                    text-alignment: above;
                    text-size: 15;
                    text-padding: 6, 3;
                    text-style: bold;
                    text-color: #F2F7F2;
                    text-background-color: #493732;
                    text-background-mode: rounded-box;
                    text-offset: 0, -15;
                }
                
                node:selected {
                    fill-color: #FF2B0A;
                }
                
                node:clicked {
                    fill-color: #FF2B0A;
                }
                
                node.city {
                    shape: rounded-box;
                    fill-color: #119DA4;
                }
                
                node.restaurant {
                    shape: circle;
                    fill-color: #C2B97F;
                }
                
                node.leisurecenter {
                    shape: diamond;
                    fill-color: #F2F7F2;
                }
                
                """;
    }

    private String EdgeStyle() {
        return """
                edge {
                    fill-color: #BCAA99;
                    text-size: 15;
                    text-style: bold;
                    text-color: #F2F7F2;
                }
                
                edge:selected {
                    fill-color: #FF2B0A;
                }
                
                edge:clicked {
                    fill-color: #FF2B0A;
                }
                """;
    }

    private String SpriteStyle() {
        return """
                sprite {
                    
                }
                """;
    }

    @Override
    public String toString() {
        return GraphStyle() + NodeStyle() + EdgeStyle() + SpriteStyle();
    }
}
