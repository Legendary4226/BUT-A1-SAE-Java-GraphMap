package com.risa.graphicinterface.graphstream;

public class Stylesheets {

    private String GraphStyle() {
        return """
                graph {
                    fill-color: #88665D;
                }
                """;
    }

    private String NodeStyle() {
        return """
                node {
                    size: 20px;
                    fill-color: #119DA4;
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
