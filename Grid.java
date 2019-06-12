import java.awt.*;
import java.util.ArrayList;

public class Grid {
    private int dimensions;
    private ArrayList<ArrayList<Cell>> grid;

    public Grid(int dimensions) {
        this.dimensions = dimensions;
        grid = new ArrayList<ArrayList<Cell>>();
        Cell.setSide(GameDisplay2.size/dimensions);

        for (int y = 0; y < dimensions; y++) {
            ArrayList<Cell> builder = new ArrayList<>();
            for (int x = 0; x < dimensions; x++) {
                builder.add(new Cell(false, y*Cell.getSide(), x*Cell.getSide()));
            }
            grid.add(builder);
        }



    }

    public void render(Graphics g) {
        for(int x = 0; x < dimensions; x++) {
            for(int y = 0; y < dimensions; y++) {
                grid.get(y).get(x).render(g);
            }

        }
    }


    private boolean shouldExpand() {
        boolean expand = false;
        for(int x = 0; x < grid.size(); x++) {
            expand = grid.get(0).get(x).isAlive();
            if(expand)
                return expand;
            expand = grid.get(grid.size()-1).get(x).isAlive();
            if(expand)
                return expand;
            expand = grid.get(x).get(0).isAlive();
            if(expand)
                return expand;
            expand = grid.get(x).get(grid.size()-1).isAlive();
            if(expand)
                return expand;
            //for second square
            expand = grid.get(1).get(x).isAlive();
            if(expand)
                return expand;
            expand = grid.get(grid.size()-2).get(x).isAlive();
            if(expand)
                return expand;
            expand = grid.get(x).get(1).isAlive();
            if(expand)
                return expand;
            expand = grid.get(x).get(grid.size()-2).isAlive();
            if(expand)
                return expand;
        }

        return expand;
    }

    public void expand() {
        boolean expand  = shouldExpand();
        System.out.println(expand);
        ArrayList<ArrayList<Cell>> holder = new ArrayList<ArrayList<Cell>>();

        if(expand) {
            int oldD = dimensions;
            dimensions = dimensions + 2;
            Cell.setSide(GameDisplay2.size/dimensions);

            ArrayList<Cell> top1 = new ArrayList<>();
            ArrayList<Cell> top2 = new ArrayList<>();
            for(int c = 0; c < oldD; c++) {
                top1.add(new Cell(false, c*Cell.getSide(), 0));
                //top2.add(new Cell(false, c*Cell.getSide(), 0));// r and c potentially could be switched around
            }
            grid.add(0, top1);
            //grid.add(0,top2);
            ArrayList<Cell> bottom1 = new ArrayList<>();
            ArrayList<Cell> bottom2 = new ArrayList<>();
            for(int c = 0; c < oldD; c++) {
                bottom1.add(new Cell(false, c*Cell.getSide(), (dimensions-1)*Cell.getSide())); // r and c potentially could be switched around
                //bottom2.add(new Cell(false, c*Cell.getSide(), (dimensions-1)*Cell.getSide()));
            }
            grid.add(bottom1);
            //grid.add(bottom2);

            for(int c = 0; c < dimensions; c++) {
                grid.get(c).add(0,new Cell(false, 0, c*Cell.getSide()));
                grid.get(c).add(new Cell(false, (dimensions-1)*Cell.getSide(), c*Cell.getSide()));
            }

        }

    }


    public Cell getCell(int x, int y) {
        int r = y/Cell.getSide();
        int c = x/Cell.getSide();
        return grid.get(r).get(c);
    }

    public ArrayList<ArrayList<Cell>> getGrid() {
        return grid;
    }

    public void update() {
        ArrayList<ArrayList<Cell>> holder = new ArrayList<>();
        for (int y = 0; y < grid.size(); y++) {
            ArrayList<Cell> builder = new ArrayList<>();
            for (int x = 0; x < dimensions; x++) {
                builder.add(new Cell(false, y * Cell.getSide(), x * Cell.getSide()));
            }
            holder.add(builder);
        }

        for(int x = 1; x < grid.size()-1; x++){
            for (int y = 1; y < grid.size()-1;y++) {
                boolean alive = grid.get(x).get(y).isAlive();
                    int count = 0;
                    if (grid.get(x - 1).get(y - 1).isAlive())
                        count++;
                    if (grid.get(x - 1).get(y).isAlive())
                        count++;
                    if (grid.get(x - 1).get(y + 1).isAlive())
                        count++;
                    if (grid.get(x).get(y - 1).isAlive())
                        count++;
                    if (grid.get(x).get(y + 1).isAlive())
                        count++;
                    if (grid.get(x + 1).get(y - 1).isAlive())
                        count++;
                    if (grid.get(x + 1).get(y).isAlive())
                        count++;
                    if (grid.get(x + 1).get(y + 1).isAlive())
                        count++;
                    if (!alive && count == 3 )
                        holder.get(x).get(y).setAlive(true);
                    else if( count < 2 || count > 3) {
                        holder.get(x).get(y).setAlive(false);
                    }
                    else if(alive)
                        holder.get(x).get(y).setAlive(true);

            }
        }

        grid = holder;

    }
}

