public class Game {
    Graph myGraph = new Graph;
    myGraph.randomlyGenerate(5,50);
    RendererFrame myframe = new RendererFrame(500,500,"Pathfinder!", myGraph);
}
