package renderer;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.awt.*;

import static org.junit.Assert.*;


public class ImageWriterTest {


    @Test
    public void writeToImage() {
       ImageWriter imagewriter=new ImageWriter("Image",1600,1000,800,500);
       int nx=imagewriter.getNx();
       int ny=imagewriter.getNy();
        for (int i = 0; i < ny; i++) {
            for (int j = 0; j < nx; j++) {

                if (i % 50 == 0 || j % 50 == 0)
                    imagewriter.writePixel(j,i,Color.green);
                else
                    imagewriter.writePixel(j,i, Color.BLUE);
            }
        }
       imagewriter.writeToImage();
    }
}
