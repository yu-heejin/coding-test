string input = Console.ReadLine();
string[] splitResult = input.Split(' ');

int a = Convert.ToInt32(splitResult[0]);
int b = Convert.ToInt32(splitResult[1]);

Console.WriteLine(a+b);
Console.WriteLine(a-b);
Console.WriteLine(a*b);
Console.WriteLine(a/b);
Console.WriteLine(a%b);