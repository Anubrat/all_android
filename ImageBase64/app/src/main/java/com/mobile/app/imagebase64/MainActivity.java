package com.mobile.app.imagebase64;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    Button bt;
    ImageButton btn;
    TextView textView;
    ImageView imageview,imageview2;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (ImageButton) findViewById(R.id.btn);
        bt = (Button) findViewById(R.id.button2);
        imageview = (ImageView) findViewById(R.id.imageView);
        imageview2 = (ImageView) findViewById(R.id.imageView2);
        textView = (TextView) findViewById(R.id.textV);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 10);
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ves="/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUSExIWFhUXFhgZGBYWFhgXGBcXFxgYFxoa\n" +
                        "FhgZHykgGBolHRcXITEiJSktLi4uGSIzODMtNygtLisBCgoKDg0OGhAQGzclHyUtLTUtLy0tLzUt\n" +
                        "LS0tLS8tLS0tLS0tLy0tLS0tLS0tLy0tLS0tLS0tLS0tLS0tLS0tLf/AABEIAMQBAQMBIgACEQED\n" +
                        "EQH/xAAcAAABBAMBAAAAAAAAAAAAAAAGAAMEBQECBwj/xABPEAACAQIEAgUGCAwCCQQDAAABAgMA\n" +
                        "EQQSITEFQQYTIlFhByMycYGRFDNCUlOSobEVFhckQ1Rik8HR0tOC8DREcnODosLh42Oz4vEIZLL/\n" +
                        "xAAZAQADAQEBAAAAAAAAAAAAAAAAAgMBBAX/xAAwEQACAgEDAgMHBAIDAAAAAAAAAQIRAxIhMVHw\n" +
                        "BBNBFHGBkaGx0SJhweEjQgUykv/aAAwDAQACEQMRAD8A7jSpUqAFSpUqAFSpUqAFSpUqAFSpUjQB\n" +
                        "i9NviFXdlHrIFAHE0WQvJl1kQ5mJVinWE9We0DYgKRtl8DUe+HGMjESWVtREiQrnGTMOw0edgd/S\n" +
                        "Fc0vEpXt1+hdYJNXfpY9x3GSSdbLgzNiXM/VKIMUyxoOpDhrA9XodCGtfvvpUWObGhEJwshLKCzL\n" +
                        "isWLa5GLBToQdcqltNRpe1hgMdOgZ+qxDK4tGLwlSx2KXZWGgY219lhUiLixVITIk46tmDXZSzEI\n" +
                        "ygMqyFmNnU2a9jY8r1zPNPU6+7+XKH8j0vjvoVskWOvZcMHHnAS2LxlhkIUeke0G1I8BoDUzjPBZ\n" +
                        "HwQMUX5wwjLLnkIALKzDLI/Icudrc6l8Y6TRxwGR1ZVaO4OdA1iLggBtDqNTagnh/lKgiR16rESB\n" +
                        "tC4Z3VdLHtMXtoV9dr+J2CzZN0vX5/Uk9C3bLFMFxNI4/wA2WXNmz54wWjykAX8+M4OpFgfbvV8/\n" +
                        "CJmwb54YVxXat1SZhbOQuUM3pFPHQnwoXwflCjl6mIRtG6G6NM7ICBoBojZuzoTbvOlWuI4xkSNQ\n" +
                        "ILgdXb4S9wrut1cmMFCRbU621FxpTZI5bVqt+/XjtjQUHxLvr8e/UbwPBMfESHgw80au9s8cfWuq\n" +
                        "q2XtZ7IGygXNyM431AKcDxGHCmSP4NMgL381hmaMkot8vVA929hrULC9KICq5JMMvZFkM5DKALWK\n" +
                        "dXcWqpm4tDJF1TLCerBZc2dxf9kBDc68x30sJZIytrvqGmL2b9f2C4dLMN83Ej14PFD74qsOH8Ui\n" +
                        "nv1bE5bXBVkYX2urgHkeVc54pxTDrlFoOyAqhUlXqyXFrEgZTck/wou4HxVJsSwRwcsbBrNGxbI6\n" +
                        "5XGRjZWzNYGx0OldMMspNJx6k5xilaYS0qVKugQVKlSoAVKlSoAVKlSoAVKlSoAVKsXpUAIGs1Ei\n" +
                        "xsVvjE+svr76cXGRnaRT6mB52++gB+lWnWr31q2IUc6AHaVMHFr4+xWP3CsjEr3N9R/5UAPUqb64\n" +
                        "dx9xrVpwOR91AD1Ko5xX7LfYPvNaPjgN1I8SyD/qoAGcT0FLFsuPxcYYk2WS4ALFrAPmUAXsLAWq\n" +
                        "v4F0Ahym+IxHYYxCzjVYiUBOZTZtDfLYeGlGn4SS9rr9dP6qqOBQRPG0mpzyysSJTY+dex7LW2tr\n" +
                        "SeVGjdTI58n+DO4kPiZDf30xjOgOAVcx61QvaOWRrWQXsRa2XQ6C17nvolMaC3Z582J+81D4zJH1\n" +
                        "LghbFSN7G52A8Sbc62ONagnOosBuAdHVxLdcY0jwyWWCIIv6M6ML3AbTVyCb3A5mp3GoMPhWRUwy\n" +
                        "A3zu7QCXNBEnaAke9m2GrX7Ogov4Wq9VHk9HIthvYW5nvve9UHSxZUmidY3kR16nKhNlZ2U5pFtb\n" +
                        "J2RqASATYGq5Z3KkqXT8k8OPTjTk7fX39OiFjOi+ExMZUQ5ASSLR5FJue00JARwT3rcjnrQ/wjoy\n" +
                        "ISsGJOdvhEaK92DNCFaRVzXuQHVWvvY5T3Uf8NwbRQxxsSzJGiFu8qLX7ztUTiOJhjmjaUINQM7a\n" +
                        "WbtMgHsBrIPUnF7/ANG5UotSi63+dm/4u4ACxijItbtMW09bGsJwXh24iw+517J1Bsdb8iLeFqfP\n" +
                        "H8NlzdfFbvBuO/l66bg6RQMMwnjIuQLDfW2naqTxxe1fQqskvR/UrOKcIwBkwyrHDZpspAy9oCOS\n" +
                        "UL32zxo1hzUUR4LhcMJJjiVCRYlRa4G1/fVFxLj0JMZ6xbxyhvQtYZWRiMzi/pcr+o1LHSOI/pRv\n" +
                        "b0CLE663bT1nTxoWOK3SBzk9m/qX1KqP8YI7XzEj/dsDbvy3vbxtTLdLMOL3lXQgH22PfqNRrsKc\n" +
                        "QIqVDh6WYfTzl7mwKozC/rFxTUvS3DD/AFgga7KBqNx2h6qACilQivTTCG9sUTpcA5Bmtvl7Pspk\n" +
                        "9NILBhiBY20Z0G+ovaI6+2gA0pUBnp1CCQZhcX2kJ2BudIawOn+G086Tfn1igeo3QEe2gLDy9YZr\n" +
                        "C9AS+UHDG3affXzib2NwLHlcf96cl6awm9o5mG1w6638M9+e9u6g2gs+GN+z76VAn44n5k/uP9dK\n" +
                        "sse492LD4vHLzOvfJGLfUuPdWz8QxtrWPLX4QRqL2+ULb6gCx03qvHSKLa0n7tq1bpBHyWX6h+yu\n" +
                        "T2iR0eykr8I8QF+1awH+ssRf2obj132rAx/EyQfhFr8hIhA7v9Vv9tVzdI1+inP+Bf66bPSEDbD4\n" +
                        "j6if10e0TBeFoumxGPbefX/fFR7QuHW9R54sXLpJOoH7Mk//AEhP41Xfh86fm2I9yae56dXj7H/V\n" +
                        "p/cn9VL7Rk6m+yRf+pKGCnG0y3ta7dfJ6rZpdKzJBijf85W19sk1rcwbTi5qIONSfq0x+oLf81aj\n" +
                        "i036rJ7WUfwo9oydfsC8JFcR+5KHD5TocSbW17WKtptb8409lKLgoDA9YQ3IqJQdfFpmv7airxHE\n" +
                        "/qh9stv+k1uuMxf6qO747/x0edPr9hl4e/QlR8HC6rKy3+bHENe+5Unc1iTgq6EyuzWtdkw97d1+\n" +
                        "p2pv4TjLf6Mo/wCKf6KXWYw/6ul/9439FHnT6meyroJuEpc3kk1A+i28PN6ba9962Tg0IsbEkENc\n" +
                        "5Ccw2IOTQjkRrTYTGH9DGP8AGx/gKyIsb8yL3P8AzrPNl1YLwv7L6EleGAjSbFAAWsuLnUC+9grg\n" +
                        "e23jvSfgsZILPiGsbgNi8QwuOeUva/spr4LjTyiH+F/663+B40/Ki+o39VDyzfqzV4ZJVS+hqeAw\n" +
                        "f+qTe/8ApWJGvPaSsNwfDg36smwtczTtpbZgzkHv17geQpxcDjebx/UP8Wrb8G4u9+sQf4P+9Zrn\n" +
                        "1N9nXREdeD4YAAQroRuznUbbt408vDMPv1Ed/FQfvrP4KxX0q/uxWfwPivp7epF/iKzVI3yPcYg4\n" +
                        "XhwCBh4AL/Qx9w27NYfheGAI+DQa/wDoxa7/ALPia2HAsTzxT/Vj/ppfi/iP1qT6qf00XI3yYkY8\n" +
                        "KwxOuFg9sMR/6ayvD4F1XDwqdRcRINDvsOdSfxen/WZPcn9NL8XJzviZfZlH8K39TBYV1G4sNGo7\n" +
                        "McYNraIo7+4eN/bUlFHcBp3AfdTY6MSc55vrEfdWfxWP0837x/51lM3y11HM2lxf38qwZT84+81o\n" +
                        "eid95pv3sn9VanoivOSX94/86NLDQuo4HYnc/bWY2bvbc6Zjf76aHQ6Pmz+12/iaSdDoRzP1z/Oi\n" +
                        "mHlrqSllbUXYe01s8h7zc89ajjobAfk3HrvTi9DMOP0Y1Fj4juPfRokbpj1MZm76VafiThfoV9wp\n" +
                        "UaJBph1CH8GJ80e6o/EYEijaQpcLYkDexIH8aIerqv48CsDkd1tGCG52sx0Gvf311rDFujmn4iSi\n" +
                        "2mCQ43DY+YbQA+J7Srpprqw+2kvHIyGIw0nZAPruyoLab3cewGonwVliZrS3aRV/0lD2VVnNmCaa\n" +
                        "5Bb/ACaPpJxz4DB1jJKxeVUC/ChyR2JuqaWul/WKt7NBbnIvG5ntf0Dbg+LWdynUMlkD3bYhiMtt\n" +
                        "Od71cjADuFM9H07TAqQUihjJLEm6dYCNe6wN+earvJUXijZ1QzTa3YO8avBF1ixdYQyjKL3s2l9A\n" +
                        "dqoV6QS5WYYX0culn1LE7adwJ/8AuiPpkVGGsUDBnUZWcRjQ5vSzDu2vQekERhLdTACZQuuJJFlR\n" +
                        "iTcS+l29r8z4VeHh4uNtHLm8XkjOk+/kTI+kM5vbCbcssmpva1z/AJ0q06P42aeRlkgEahMwbXU5\n" +
                        "gANfAk+yqGPDxCF2KYfV41HnXI9GRjqHJvp9+9EHQWFM07KqDSMXRnO+c2Odja2m3/0SwQStIzH4\n" +
                        "nI5JN9/IvRhBUPi4aKIuuS4K+mQq2JANyfXV5ahHyncSbD8PmlQLmUx5cyh1uZUGqnQ6E1JQjZ0z\n" +
                        "yS0umQG4vOQ1nw4IAI84hHpqtjrpox9tq0i4tiTmPWQdlb2UrzZF1Ntu177UFdBuk02K+E9b1GVE\n" +
                        "jt5hALtKo1yqSdqtOkvFWhwmIkjMAZUjsVhXniIL3zR2ItfQ+HdXR5UKujhefLaWoMeA4yeWXK7R\n" +
                        "lbG4WxNyGI1A27Jok+DCuW+RnjGIxMjtLIGGdVAEcaDSGdvkKL6ke6uv1GUY3sdeKctO7K3FwERu\n" +
                        "QbEIxBO1wCRfQ6eyhV+JTZyhmiFs4uEkvdVex1FtCt7c9aLeNSFYZW+bG57tlJ18NK4VwvpLizxg\n" +
                        "Yc4mUp8MkQpm7JUO4AI58t62EY+qEzTnaph/BxWUsAcSh1GgSQFtfRvsPXpW2AxOJbJIZiyLIiyC\n" +
                        "wuVJUljZ9iGtpt3UsDi5C0d5JrFkGq2HaIFj2tN6GfJ3xXETYKYyzySOsrgGSRibLAoyqxPfy568\n" +
                        "6tOEV6d/I5oZJy/27+Z1/wCD1gwDnsf8/wAalPzplyMpuLi/r5d3srn0o79bOfrNIGCnESXDAEWP\n" +
                        "I6j0q1mikOb84ma19FiLej3dvWuYeUbjE8XEsVGmIlCrJ2VEsgUXVTYLewFya6xi5CzMSxs3a+NA\n" +
                        "Fn7Wl9h2tK6IKL9O/kcGRyS3f3/IzicBMHb42wY6iG4sCdrm1rc9fVR8kAtXl3p82XH4ja5ZX0sR\n" +
                        "eRFkv723r1BwmXPBE/z0VvYwzD7CKnNLai+Fvc2aG3KgzjnDx17t52zEEZHUAdkXHom2t6NiuvsP\n" +
                        "3Vxfy+4Sxw8u47S6gXBYC2vMebNLCrHy21QUycID2ZRiNVW5DWUkKFa1lsNQb+ulieGxLlzNIDlG\n" +
                        "jTRIRa6Xs4vrlvfnVH5McWr8OiFl8280ZvcfLEoGm/xpoc8suGX81myqR52IlSdgVkUHTTWSS3tq\n" +
                        "72VnKlcqs7Z0fVDAgRgwS6A5g1wuxLLoTlK61ZdVQP5GcaJMAgBvlVQdbkMC8ZBHLsxxn20fGoTj\n" +
                        "TOvFK4oj5BWacy0qWilm9qg46btrHceiWO99wFtpbk255VY1umGX0sov3219/dTJ0SnwVuRQFudr\n" +
                        "k++33LXBfKri4hNhFaxXrJZ3EYYZld44zq9jm8w/KvR7QKd1B9YB0qvxXRzByEGTCYdyBlBeGNiF\n" +
                        "uTYEroLsxt4nvplJVRKnqT6Fd0d7QmkvfrJr6ajsxxqbHmMwb31cU3hsHHEojijWONb5URQiqL3N\n" +
                        "lXQakmnrUnJeKpAd5QMZYRRXAJzPcoj7dkaOCOZ5UMTN5iK8ii7zNfqYdbdUg0C2uMj625+FdfhQ\n" +
                        "WvYXO57/AF1sUHdVo5qSVHHkwOU3K+e+px1pLQKOtW7TOf8AR4T6EaAC2wsZG131ou8ntjDK2YNe\n" +
                        "W1xGkeyLp2NDvvRqFFMzb0Ty6o6aNxYNOTVffzGSK535b3H4NZLjNJLGACQLhTnNu/0RXR8tOQLv\n" +
                        "UTrlwebfJZgpFGKOWQArFYqhJNmY6Xt3UQdLsDNJgZgqYhywjABib6aM3AF7kAHau8Uqosn6ao5X\n" +
                        "iuWqzhXkM4fPFLKkkMiKGVwZI2juTHKhAzWvuu1doFSZtqZtU+Tphsir6Qwl8NOi+k0Mij1lCBtX\n" +
                        "B+C9G8Z+FkxJwmJCNjM5JhdQEeUnMSRpYG/hXo1RqKk1qdCzVnLsFwacPGfg04AdDq4OzKbnzY/y\n" +
                        "KEeh3CMfhuthkwM4jeQyCURscrA6gqNSrKosQLg23F7d/tWLU88rl6EIYdKe5AhuVUncqL+uwrSR\n" +
                        "Ty+6pIFZtUzr9DhPlC8nWOxePmxEGFYo+TtF4luwWxIGa9tBqQCaOsL0Vm6uMNhlLiGAMS7XzrDG\n" +
                        "rXyygaMpGg5c966HGNBW1PHI48HNPGp8nBumvkvx2JxXWQ4dAnVRKfOgDMi5T6RLHYb11TohhJoc\n" +
                        "HDDOuWSJFQjMGByqACGBNx66JbUxKNaVybHhGmR2B5UFeUrobPxKCOOLJmRw15JGRbWINwqMGOvc\n" +
                        "LXNHdbxb1nBWW6Oa9AegGMwUMsMpw7BpVdcpZwLple+ePT0U27jT3TPyeT46AQq8KFZVcGxtorq1\n" +
                        "8qi/pL7q6VSptbqiGhXZzryb9BZuFdYHkikWS2qBlKkDkCNQSBzG1HVqkSjSmRS23yVgklsaW8KV\n" +
                        "OUqKHMWqSKqMFxVZDIcrosTFS7gAEr6WUAk6abgb1IbjUA+XsCfRbYAk8u4VtWTkywpGqteP4c/p\n" +
                        "O/5L8tTyrMfHYHIVXJLaDsPufWKNLEtEilWRWKC5Jj2FbVUN0hgF9WNiRojfJ0PLwrEnSSBSQc9w\n" +
                        "SDZCdRoa3SyLaLio8m9VsnSfDroc+wPoH5QDD7CKm4bEiVVkW+VhcXFjb1VlM2DVm9OwCm6iY3iy\n" +
                        "QkBgxuCdLctOZFFDSexZ0qovxqhsDke1yPk7gKfnftCtfxsisWyNYEDdN2DH537JrdD6EtcepeS0\n" +
                        "1Vbw7j6Yh8iqRZS1yVOgKjYH9qrK9FVyVg7Wxld6fqPfnVKelK7BAT3Z9r9+lZpb4Fm0uQipUPN0\n" +
                        "ja5HU7X+UdbG3zay/SFhfzJO22c/ctbpYupFxStTGAxBkjVyLFhcjXTXbUA1IoKp2hyLat6pOLcZ\n" +
                        "aAplQOGBN+1yt81T31CXpLIRfIg7Vtc/zQeYHO9bob3IyyRTqwopqahz8YpbE2i0I+3N3t4CneE8\n" +
                        "aeaXITHlysewyk3BUcnOmp5UaHyapq0XVbJuKxSFYWJNKg88alVQWl3v8i98psdlvWH41LmI661i\n" +
                        "bdgnS5tc9X3Cm8tnPrS5DBhUahluMyXNpSdAw7OwYBhqU7jV5wyfPGtySwUZiebW19vP21jg1yUh\n" +
                        "NPZEqlWaVBQqeGD83LHZzK+vzZJHcX/wkUB4mXK2IHwiLzaID2HuplKKubzdtQzaC+48bdBniEeG\n" +
                        "EY0CqqD1KAu3Ouc8Ux6gYhuuTt4rqxeFDbqFYsp7Pa+MTU3tbS1Pi5o5vEcETCzAZ3OIiAWKQnzb\n" +
                        "nVvNC/m9s8q+NW3QV1lxK+dicoMxCRMpGhFyWjUb9xqkXHgQTMZ0XWKMMII7KSzSEHsjNcReyiby\n" +
                        "XSiQzSCVZQAq3ESR2J1tdVF9vuq2R/pff8HNhTeRd/yH9Inwv4Dc+q9Kserfl665D02c94+0Kguz\n" +
                        "lWkmRAxhjazSyWAsNSCLi5J79Nqp8Zjo87/nFyWfbDIdSx5k6090nTM2BUAgtj8NIQdOxDCZXuOW\n" +
                        "n2iq3A49HeNPhNy7oPiE1LNl3zczXThbad9/Q87xEVtXf1LHhPG8PPxJsJ1jO4eZCnwdVHm0dGHW\n" +
                        "FuVtDbkK6P0efNhYDrrDGe0AraqDqoJAPgDXBOgcgfi+OlOtlxT3JsAGlVWP1GavQXDY8sMS/NjQ\n" +
                        "e5QKhKTfJ14oJXRJoT6dcRWMKXzgLFPJmW1gE6q97ka9rQeB25lTGuY+XDFLHhFBtmkvEuuwZ1kZ\n" +
                        "vdDl/wAdI2/Qq0vUq+E8cTEYUSJJiAOvlX0Bm7McBN7S2A7Qtr3+3PFOOx4bDNK74kj4RCmgCntR\n" +
                        "4k2BMhBGhv6hVL0GbquHoc8y555280xCkBYUuxzDXsae2m/KFis+AALym+KiPnXLWtDidrk2319l\n" +
                        "dep6O+p52leZ+3x6HTugXE0nTDSKJPOQTkGRwWyrOB2gOeYm1jtRpeufeSuHLhMCdNcLN9s0bfcw\n" +
                        "91H5rmbO+CVDOMksjeAv7iK4lxfpzCmJ6nq8QTnSxWdcnatY6pcDX7K7TjfQblpvXm3yowrFxNbA\n" +
                        "DsQtYbDn7axSaexk4xa3Ok4woJZBkxBtJJs4t6R2HV7d1E/R/hUE8WYwm6sFzliH0jjIvlC30bY9\n" +
                        "1CXEYh183msST1j65lt6ROnmjprprtRr0IcCCSOzAgpofSGbCwPZrWINm7h7K6ZtqKOLEk5suOCx\n" +
                        "5YUXYAGwO4BJYA20uL2qdGbkiq7gPxCCxXKMticxGXSxbn66sIfS9lc7e53L/qAPli40MDDBP1Il\n" +
                        "JkaOxZksGXNuv+wKFug3Sr4ak/5ukZjaL9I2ocSg6swtYqPfV/8A/kNhC/DEcfo8TGx8AySJ97LX\n" +
                        "NvJFG2fEIRpJAkihjlDCOcIWBJA0u433p4SdpWQnFU5VuHPHeJPh8LPOkMRMaKwBkZh8dEDcLLfY\n" +
                        "k38KMMJM5xUbebyuDZ1BzEMVKqbnUFSxv+yNqDuO4M/BsQvVpdsPOBaQEk9U7Cw6w31UbC9P9GOJ\n" +
                        "SdZhj1xyNHA3VupNg+G/RNrpntpps29Uny/cRxPZX1/s6lWC1I1qa52egjivlN43jMPDHJG4W2Jx\n" +
                        "ULXiiYWWQhLZlOW4jLad96LuCuJ8NDOyreSGNr9WmpKLmv2DrmDUJeWpQIZlP63E6DvJw3a9Q9L6\n" +
                        "lX3kvxTPwzD7kqJI9lOiSsRe+xsw91VxtnNkin6AV5TekGLwmJjWCYojwg2VUtmV3QjVQdlXTxrq\n" +
                        "Xky4m8+EikkbMzRAlr7sGIN/HT7K5r5ccGxjw8tvRkkQnTUOqMu3LsP7zVz5A+JO8TwnURNYWt2U\n" +
                        "cZgW01F8/PwrH6998hHZx774OxXpVrelU7OmjWfDs4ADZbNfnqLHTS1t/soV4l0PxcgULjdQ0jEs\n" +
                        "rG5dgQLXOgCqB7aN1FZpoyadnPkgpqmAEPQfGCLIOIsjmXOZEVgSgTKqaMNASx9tXvRvg82FV0mx\n" +
                        "LYgs+YMwIKrYDLYsdL3N/GiKo8x1olNvY3HjjF2jQ1pIjEELa5BGvK432N63vTkG9KWfADY7oLiJ\n" +
                        "MRHKuIjjWMTkAKxfrZYniRy1wOwCmgA9E99YwHQfGpMkknE3dFZSyecGYCxy3zne3dXQaVMptKkQ\n" +
                        "lBSds4rwPyMYjCu7jGRsskMsUi5GTMkqFTZu1YgkMNDqorrwqVJsajClKwRqaDPKD5OzxYwk4nqR\n" +
                        "EH0EefNnK6ntC1sv20bWqRGNBWGzexzbAeSxosPDhxjSBEZDmERGbrGDajPyt9ta8X8k/wAJh6mT\n" +
                        "HP8AGB83VC+isttX/aJrptKn1yqiHlx1avUFOifRX8HxRwiXrFjEgU5MhtIysb2JB1Wr80/Pypqk\n" +
                        "OiPBHxGHzqVNte/XXkdLbGx35UDdJvJFDjp/hEmKlD5EXsoluwLA2roQqRQLMGJeiF2ZhjMUuZic\n" +
                        "quAouSbAW21rfC9GZI5C646coVRTE6xOhyRLFmN1zAnKGNiLkmiWlTOTZJRSdorcHhOqXIDoDcWF\n" +
                        "rX1OlzzvTpW9Oy71rWF1wU/H+jceOhOHmeTqyysQrC5yG4BLA6Xtt3VD4Z5PsJBIZVMhYxtHqygB\n" +
                        "GfOVAVQAM2oonj3p4UW0JJblMejWHIIIY3BBu7bEEHn3E1W8N6AYLDpkhEqLe4XrpHVTe9wjkoDf\n" +
                        "nlvRXSocmxFFLgiLtSIrNqwaC5CxvR7C4kg4jDxzFfR61Q4HqDaCpOA4LhoVyQ4eKNblsscaoMxA\n" +
                        "BNgLXIUC/gKkwGnqwnLkgYzguGmGWXDxSLcNZ40YZgCAbEbgMwv4mmouCYaEh4cPDGw0zRxohsdC\n" +
                        "LqBpVpWso0NDMXJFtSpZqVBYmCs0Kx9L774dl0J1NtFUseXcK3i6WgkDqSCSAO2N2IA5eIqmiXQ5\n" +
                        "fMj1Ceor70NSdOYwL9UT3Wca93LSiRTfUi3hSuLXJTHJPgVqegG9NVB4jxlcOVVlvmBO9tL29tFX\n" +
                        "wPN0ty4pVTYXjwkuVQ6NbU+APIG2jCnJ+MZFzMo5DRuZ9YHifZRTJWizk2NR6rsPx9JJBEEIJv3W\n" +
                        "soJP3WqyoquSkH0MVITao9VeI6SIjtHkJKnLe4sTp/UKEm+DJtLkvqVUA6SKbebOqg79/Latpeka\n" +
                        "ixCXuW52PZCk2019L7K3S+gmpFxNypqq7hvGevd0yZcgBvmJvckdw7jVlWVXJSDtbCFSBUcVSS9I\n" +
                        "ZQCRhzYX+dyudbDwNFN8GTaXISVihSfpRKpI6g8tbNzAPdWT0jmyBuqOY37PVvyYjU302HLma3RL\n" +
                        "oT1x6hJNv7K1qn4FxWTEGTrEyZcluyRfNm7/AFVb1lNbMrFpq0bR70/ULEOQrFfSCkj1gG1DkvSD\n" +
                        "Ejkg5/I1/wCehRbews3QY1ihn8NtcgyoCGItdORt3+I99Q5OPz5yquhFgRql/RGbn33rVBiOSQUu\n" +
                        "NTWLVX8ExTSRlnN2zsDa3K1ttNiKsBS1WxeLtWbw71Iqr4g7CJypysFJB7rC/wDChzD8RnzKGlY2\n" +
                        "Zb2D6i+o9AcgfspowcuCeSSi9w3pGgVcdPaxma9v29xmHJf2ftp2fFyXPnXHOwL2FwG+5hTPEyfm\n" +
                        "IKOppUIfBcT9JP8AXP8AOlSeQ+o/mvoRIcQj9aQZ7hCeWvWN1QAAl3s4tsNO+pEQUEW67MMza7AI\n" +
                        "JHtbrOem/h7MYSyxMS79qRFva/oK0jaAbHLr99PYeQm4zyMctgDn+UY4iR2BY6Pt873dDOZURIjn\n" +
                        "ZEBlF2UXubekRymsRqO+juqDh3AZlkSR2FhYsM5J0At8nXtDw9tX5Fqlkds6MKpMVDXHsQDiYoy0\n" +
                        "inKNEY27UgszZWGl0I/zYkhoM6U4pFxDktqkV7AbZYne7MTsNDYDl41kORsvCKzA8Q66OOSJ8Qqk\n" +
                        "7EvmJXqAc1pT8wg6828bysHA7L8dOe3DuzjZDfeQ2F99d9CDUPoyyxYREWYLbrzazG46/EsCSU2y\n" +
                        "qNO5ffdYZ+zcyIfOnZSNFUaGyb6fbvVbdd/g5dKvv8ljwjDMJgSzGyNuSd8oHyiOZqZiOkODRsj4\n" +
                        "qFWzFMpkUHOu62v6QuLjlW3D/jGFxcKNNeZ77DurkPFulWFGJdUV26ySUmTq0LMryFsqEuMqnOdb\n" +
                        "a6GpVfJ0atK2OrN0qwIzfncPZ9Kzg5dL6220qiTiMeIkdopHcZwTkzgBXZGX9KLqQl722zeIPPH6\n" +
                        "ZRITbDkBLlEsijMflNqczX+6jDg+N68fCFLKOow0b6H04lkkNmS51GIB2G1NFU9hJS1LcuMMoEqo\n" +
                        "xlNlX5TZfi0Nj5w3Ot+fP1mLxDjeHinSJ2chc5kIZckR6oMvXsZR1eYAZbix8Kn4IZpz5wHsgZQD\n" +
                        "mssMN8zFQTrc78/dzzpJ01fD42ZIzGFaYNmkAbMpigF97Wsl+/teytZiqvidC4N0gwIlNsVGA6jL\n" +
                        "nmSxyknsEub3zH6p1ogwXFsPMSsM8UpAuRHIrkC9rkKTbUWrhjdPcQEclYBHmIU9X2DoD2TcAm4O\n" +
                        "x5UW+SzpIcXMOsKdZ1UwORQBZXgIzePaPuPdSNFYSrajqLNa1h3UB4zjEYSc/B2IjE9zni16uSWI\n" +
                        "gE9kElSQD3+Bo2m9R2G1c36SmNYMYSW1GNHpXPx2Kc5Tl7PoaDwA3Auo0ifjpoWKs8e6xsMzRLfN\n" +
                        "Gh3YHNa/IDnWvC8VCrQR9UoDjQOyfSIhGWxzayLz5io0WPHVxZZZficP2VZlAvHEANN75h7z7Kzi\n" +
                        "HEFXE8PfO79rISRm0M2CfW55XDd/qrolehHHGtb+If8AR6NVllCplDKnMFTlvYppqD1h520051f0\n" +
                        "M8AsMU62IJRiQe8GIaeGoomqDO2HGxqwvp36e/SgfjuPMeULC0h6snKpN9GHzULa2PhpRzXNOmcq\n" +
                        "Gd0LP2FIyqLi2WRyRZhc6EeGm+9Uwq5EfFOo7FtjJZFkkCwErnJDXl53a/ZFvkjepeAgD5HZMhIc\n" +
                        "G5f5MkgGh0sRY3PfpsKHcTkYqxBJaOFrm53jy8mHNtrbnerzo9IMoyr+kf0t9YoX7v2j7b1Rx22O\n" +
                        "eE25b/x+C+4SmUuARa4Ngb6kb3vfXa37NWNQcC3bYWA0G3Pcd3h9tTr1zy5O+HBHx/xbjvUj3i1B\n" +
                        "aTkk3aK4JWy9Wdja1rkjfb1UacR+Kk/2G/8A5NCeK7MsyhVvne1xvmGbkQbXVfHXwp8fqS8RwmOT\n" +
                        "sSzWaMAnMPigcr5H7VyGGhblQN0543iYHCxzqgMIIGSArdWdDZip1tCDa5tfbTToEbliLIlstr2J\n" +
                        "NgXiGiHuy6eygnyiRv5tskY1kB9K+piIy7rfzkx7Qtpyp5cEVzt36g/+U/FfN/5f/HWKGfhGM7k/\n" +
                        "ey/10qXYXVk7Z6M/Bk2RRdb5mJ9CxuABrl7vfc1KwMbxEtIF1Fhlt85mOw8R9tWtqh8Qw5kXKDZu\n" +
                        "TWvY+I5ipuWx1KCRLgxANUXS+WVTF1TNft3RTIMyjLrdFa1u8i3aoG6MdPZZHdJMM0ZjcIRdmbNz\n" +
                        "zARgIANbsQDsDVvxHjryk3jVl7JRS9gCA6kSjKRIjZ7kfsga71Kc0tpF8eKcv1Y96HcZLiUPZxJK\n" +
                        "l0Rc7srZ5QGRWFtGII9+tqgYrrm0eRW6zOPSLFwl4nvlUk21XXxp5MWua7RSMomgmAVow2aKNIgp\n" +
                        "BOUjsBxZudtOcTEYovG0ZWSO8aqHBVirCZ5m7KPmKNmRbgg3TUWsagtN8/U67y0k4r/z+3I2vWJG\n" +
                        "JFkTqwerWxNybFsqgrc6Fj3WvWUx7j5dhck6gAkgAkki1zYC5rGK4jJKtpc1zOZSSRkAKIioi52K\n" +
                        "2Aa42uSQTemcJMUkSQDNlYHKTa/he2htcjxpXN3s3XvOjHjTxtyir39EXGOx00MaOmIZnkUlIyQu\n" +
                        "Zo8102zb5Rz3btWsaBeOdA4ZZmmbiGQOdOwOyFAW98wBFguth/GijE8TvEY1imUGGVGdTCsheWRZ\n" +
                        "C6KJcozWOa5Q3bsgbB7HcSEokKrKodoSetKdgRpkAQIzC7Hdu6w9V1mjHdHA8GTJUZKvgBB6C4OQ\n" +
                        "sfhkoIsoOSEKxvlJsG1F+14ja9ERxfwKBIIWldUJu6BgXLox87cMS5ESqAMtjIot37YWMRvCwJYR\n" +
                        "yRPYZb5Y5FdrbXJsTqd+69PyY5iymIsjJ8KBUhiCcU4kSQFGAWQKxuWPZIGW9waFn1chLwcsTWjf\n" +
                        "4e/3lfBx14MLHixhZUeSc9a4k7TK9mYM2U5BexAcDTTQ7QOlPR3DYuRpJJ2UKoOcMLBCAqtIzEhg\n" +
                        "xU5WGUHYXtRhguJiLCwDqzJmnJAuoB6s3IJY3z9sFRYi6a2veq9+MTZOrKyuAmCVOsdLZsJL1jtN\n" +
                        "2rhpdB2A9udUlNQdMhjxTypPn+++6KR+hEDZUlzZWHZCIyKSoJJjA0Y2a5IBGnrJmdH+BwcPSQRT\n" +
                        "P1rFCt2AYGxDFSgF+yTvfRjsdak4ieM4iTEqmISRyzZ1+DiQXDAAP1rdba9gr5Vy6HuGcRjA8ca5\n" +
                        "WBQNmeQQrI5ZrjMsJKAKNBqTr755M6cWdODwbWSLfHPD7/YziOJTlSeul2P6WT+qiHpVwPFyxyJC\n" +
                        "ikyFm7RC5c8jSWa7G5GxsLG55bCsourD9k7equxC51tvrSeGfJf/AJGK/TX7/wAAbw7gMiRQrMFD\n" +
                        "9XEhCrGwzpEuYE20Xzba+q3Kq7pJ0SxTNA2GMR6t5WIlI5rHkAIW4u0ettR410FtLX0ubC/M72+w\n" +
                        "1kjlz/lXU5tnlrFFA7wTh8wkSaVAhCSoUDh7ZzCykNYXHmyNgbnbS9EJpGsmlbKJUNzuQpIGY20F\n" +
                        "7XPdflVDNwt2dnuLMxNiXuASTqNtjb2UQE1qzrzI9pFapUEoqXJQPwWRipEoFkVD6fyTv7hSj4dJ\n" +
                        "ApOfN21I3tfKV1129H3cuV02LiF7yILb9tf51Cx+MikjtHJGzXRgAyliMwY2UG/og1qyPgR4Yrcn\n" +
                        "YXCkhXUqCVG6AnUAnW/fT4B2zLf/AGSP41Ghkb4MpW5ICjQXNswBt7L1IhmJAupB7iP+3j9hoCL2\n" +
                        "MSREixyEEftfzqLNwpGYswGY2v23A020varBpdAcvO3dWizBiAU30ufVehNoHvyVMnRyJsoyA5NF\n" +
                        "Gc8mVx9qg+/vqq6QdBocRF1bGSPtA3R7nRJE5iw+MOvgvdRVHilv6NtT9l+W/L7aa4lxGOOF5ZDl\n" +
                        "SOxY72GmthrzrXOVcirHHVdHPPyWw/rmK98P9ulRH+O/D/1hfc38qVLrl1G04uiB5eIYQX/OHHL4\n" +
                        "yb+NbtxHDcsXIPDrDY/WQ1Xvj8BoTFiBcjYRHU/49T4VvHieGm9+vXLuGRT3fNJ1123rn0ZkX1+H\n" +
                        "rn7ELgUeHHwkvK6o2MmyOGszBBEg1ym+gB27qtVfCaD4XNpa3nBy/wCHr6zVVwuTDIjjEMwvNM6W\n" +
                        "ilYZXckXypo2UJpU9MVw47Sn2wzj708abKsilsjMKwuCuW/vHz8EOgxkg/4kX8YtaWTC8sbJ+8gt\n" +
                        "y5GLwrIhwRt+cIoPM5h94FbjA4H9chHrcD7zUv8AL0KPyF/sNPHhjoca3vwv9nWm3gwv62frYb22\n" +
                        "81VhDwXCPomKhY9yyITrtpmqUeh6/O+z/vWXlRtYerKRosNfXGvpp6WGHtt1VZX4KAQcWxBFtWw5\n" +
                        "8bg9UNdKnt0WQEgk6HkB7xqa0/FlO4n1tb7rH7azVk7Q/l436v5ldIIBpHiyz2st2gI59pgIszAb\n" +
                        "kDcKfXTksOGVTkxTMVDdnrIbMxN/OER2Nza7b2B8bzz0aDWUGwPJQADtqwHpbDU3NOr0NUfKHtW+\n" +
                        "2vf99OpzZOcIR9d/eUkJhMSJLMyKVZlRhEb5ndL9sPe3Viwygbacq3D4QbYl/YYrf+16vdUrgnRs\n" +
                        "YjDxSsbMQ1+4LnYqB6tT62NTj0MX532f96aeuMmo8E8SxygnLkp+uwdv9Ik5/Ltv32QX/wA95rQz\n" +
                        "YPf4Q+/OT/4fxqyxPRJFNrk6U0ei6VPzMhdYMMkQXnwVrdadrDtv48wNtayvEMGNRK1ze92kN7+s\n" +
                        "EW12qcejEfdUn8TEIGp27qFKbCWLFAH5cVgju19b7zbkEaZR3E6e3cXrV58C27P+9xQA5aBSLc9B\n" +
                        "RCehcfefdSHQuLvPuFb+vqJ/hBwz8POpzk7X6zFk8tjmuB2R7qTY3h5a5Vidb3OJ1vv8q29EM/RG\n" +
                        "NFvruOQ5+qmh0bi7qxufUeOLDJX9yi+H4D5h0H/7FreoHWsfhDhwNxGb9+Se+1rgsavz0aj7qfwv\n" +
                        "RGJgSQd7aW7hWqWTqE8OCKtqwUkx/Drj83zWFheIkjUmwJPeT76kcK4vg1nhKYezdYqqwhW65zkN\n" +
                        "je49I7eNFQ6GQ9x94/lWmJ6GwlHAU3KONDY3KkAi3PWmTknbItYvRfb8htwjRLdzEfxqRLiVUgG9\n" +
                        "ztofvoE8mHF0EKQMx6xsNh5VFmN1XDRIxzWsO0p0veiHo9xWPGoZFIIYXBB1ynl4W5+NdUk16EIJ\n" +
                        "St+iL6GTML2I9dbGq/CysHKHYA2GlrCxuLctQPdU80GMWlQuOITh5go16tyOVyFJGtS2rCm4saxr\n" +
                        "YxOmcK/HCT9Xf99/46VdQ/FmL5ifVX+VKuTRI7bxHniHyh4lMgEUBCPnAYSkE2Fsw6zYDQWpY3yi\n" +
                        "YmV3kaKDM7BiQsnJQlr9ZciyJvfVdLXN1Srs1M4dEeg3ifKBiHt5nDqAdFVZLDRQALubDs/ab30t\n" +
                        "oenuK0GSHT9ltfX2qzSo1MNKE/T7EkW6uEDwV/b8vnWH6eYk27EQI5hXHefneJpUqNTBRRn8fZzI\n" +
                        "kpgw5ZGRhdHtePLYEB9uyPtol/LpxL6DCfu5f7tKlWPfkEkuBh/LVxAm/U4X6kv92tfyz8Q+hwv1\n" +
                        "Jf7lYpVlIfW+psnlp4gDfqcL9SX+7TreW/iJBHU4TUEfFy89PpaVKikY5N8kXhnlix8EaxJFhiq6\n" +
                        "DMkhP2SCpf5ceI/Q4T93L/dpUqKswZm8tHEGNzDhdraJL/dpv8seP+hwv1JP7lZpUaUNrl1Mflix\n" +
                        "/wBDhvqSf3KkDy3cR+hwv7uX+7SpUaUDk3yI+W7iP0OF/dy/3ax+W3iP0OF/dy/3azSo0oy2aTeW\n" +
                        "niDCxhwvI+hLyN/paZ/LFj/ocL9ST+5WaVGlGqbXAvyx4/6HC/Uk/uU7D5auIKLCHC739CX+7SpU\n" +
                        "Ugc2xz8t/EfocJ+7l/u03N5auIMrKYcLZlKnsS7MCD+l8aVKikZbKfgflBxeCeN41iYxR9SudWIK\n" +
                        "b9qzAk7eGm1TYvKvi0Zmjw2FjLMWIjWZQWO5y9bYE87WvWKVNrZiSi9iyh8unElFuqwp8WSYn/3a\n" +
                        "3Pl44n9DhP3cv92s0qwDH5eOJ/Q4T93L/drH5deJXv1OE/dy8/8Ai0qVADf5ceJ/R4b6kv8AcpUq\n" +
                        "VBts/9k=";
                byte[] base=Base64.decode(ves,Base64.DEFAULT);
                Bitmap image= BitmapFactory.decodeByteArray(base,0,base.length);
                imageview2.setImageBitmap(image);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10 && data!=null) {
            Bitmap bm = (Bitmap) data.getExtras().get("data");
            imageview.setImageBitmap(bm);
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 100, bo);
            byte[] array = bo.toByteArray();
            Log.v("value", "" + array);
            value = Base64.encodeToString(array, Base64.DEFAULT);

        }
    }


}
