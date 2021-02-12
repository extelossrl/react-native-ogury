
Pod::Spec.new do |s|
  s.name         = "RNReactNativeOgury"
  s.version      = "1.0.0"
  s.summary      = "RNReactNativeOgury"
  s.description  = <<-DESC
                  RNReactNativeOgury
                   DESC
  s.homepage     = "https://weward.fr"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNReactNativeOgury.git", :tag => "master" }
  s.source_files  = "RNReactNativeOgury/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  
