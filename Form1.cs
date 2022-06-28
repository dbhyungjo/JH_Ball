using System.Diagnostics;
using System.IO;
using Newtonsoft.Json.Linq;
using System.Net;
using System.Net.Http;

namespace Expressway
{
    public partial class Form1 : Form
    {
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        static string Load(string st, string en, string chk)
        {
         string url = "http://data.ex.co.kr/openapi/safeDriving/forecast?key=null&type=json";
         WebRequest request = WebRequest.Create(url);
         request.Method = "GET";
         request.ContentType = "application/json";
         string input;
        using (WebResponse response = request.GetResponse())
        using (Stream stream = response.GetResponseStream())
        using(StreamReader reader = new StreamReader(stream))
        {
                string data = reader.ReadToEnd();
                var obj = JObject.Parse(data);
                var list = obj["list"];

                if (chk == null)
                    input = chk + st + en;
                else
                    input = st + en + chk;
                foreach (var item in list)
                {
                    return (string)item[input];
                }
        }
            return "String";
     }
        public static List<string> Load2()
        {
            List<string> names = new List<string>();
            string url = "http://data.ex.co.kr/openapi/odtraffic/trafficAmountByCongest?key=null&type=json";
            WebRequest request = WebRequest.Create(url);
            request.Method = "GET";
            request.ContentType = "application/json";
            string input;
            using (WebResponse response = request.GetResponse())
            using (Stream stream = response.GetResponseStream())
            using (StreamReader reader = new StreamReader(stream))
            {
                string data = reader.ReadToEnd();
                var obj = JObject.Parse(data);
                var list = obj["list"];

                string temp = "";
                foreach (var item in list)
                {
                    if (!temp.Contains((string)item["conzoneName"]))
                    {
                        temp = (string)item["conzoneName"];
                        names.Add((string)item["conzoneName"]+" 현재 속도 : "+ (string)item["speed"]);
                    }
                }
            }
            return names;
        }

        static string getStr(string a)
        {
            switch (a)
            {
                case "서울":
                    a = "su";
                    break;
                case "대전":
                    a = "dj";
                    break;
                case "대구":
                    a = "dg";
                    break;
                case "울산":
                    a = "us";
                    break;
                case "부산":
                    a = "bs";
                    break;
                case "광주":
                    a = "gj";
                    break;
                case "목포":
                    a = "mp";
                    break;
                case "강릉":
                    a = "kr";
                    break;
                case "양양":
                    a = "yy";
                    break;
            }
            return a;
        }

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            string st, en;
            string chk = null;
            string st1 = comboBox1.SelectedItem.ToString();
            string en1 = comboBox2.SelectedItem.ToString();

            st = "c" + getStr(comboBox1.SelectedItem.ToString());         
            en = getStr(comboBox2.SelectedItem.ToString());
            

            if (radioButton2.Checked)
            {
                chk = "_bus";
            }

            string a = Load(st, en, chk);

            if (a != null)
                label7.Text = st1 + "에서 " + en1 + "까지의 예상 소요시간은 " + a + "입니다.";
            else
                label7.Text = "이 구간은 시간 정보를 지원하지 않습니다.";

            //listBox1.Items.Add(Load2());

            foreach (var item in Load2())
            {
                listBox1.Items.Add(item);
            }

        }

        
    }
}
